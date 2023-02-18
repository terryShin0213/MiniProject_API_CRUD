package com.blog.domain.board.repository;

import static com.blog.domain.article.entity.QArticle.article;
import static com.blog.domain.board.entity.QBoard.board;

import com.blog.domain.board.vo.BoardWithAriticle;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class BoardRepositoryImpl implements BoardRepositoryCustom{

  private final JPAQueryFactory jpaQueryFactory;

  public BoardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
    this.jpaQueryFactory = jpaQueryFactory;
  }

  @Override
  public Page<BoardWithAriticle> findBoardWithArticle(Pageable pageable) {
    List<OrderSpecifier> orders = new ArrayList<>();

    pageable.getSort().stream().forEach(order ->
        orders.add(makeOrderSpecifier(order))
        );

    JPAQuery<BoardWithAriticle> query = jpaQueryFactory
        .select(
            Projections.constructor(
                BoardWithAriticle.class,
                board.id,
                board.name,
                article.id,
                article.title,
                article.content,
                article.imageUrl
            ))
        .from(board)
        .leftJoin(article)
        .on(board.id.eq(article.boardId))
        .where(article.deleted.eq(Boolean.FALSE))
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .orderBy(orders.stream().toArray(OrderSpecifier[]::new));

    return new PageImpl<>(query.fetch(), pageable, getTotalCount());
  }

  private long getTotalCount() {
    return jpaQueryFactory
        .select(Wildcard.count)
        .from(board)
        .leftJoin(article)
        .on(board.id.eq(article.boardId))
        .where(article.deleted.eq(Boolean.FALSE))
        .fetch()
        .get(0);
  }

  private OrderSpecifier makeOrderSpecifier(Sort.Order order){
    Order direction = order.isAscending() ? Order.ASC : Order.DESC;
    String prop = order.getProperty();

    switch (prop) {
      case "modifiedDate" :
        return new OrderSpecifier(direction, board.modifiedDate);
      default  :
        return new OrderSpecifier(direction, board.createdDate);
    }
  }
}
