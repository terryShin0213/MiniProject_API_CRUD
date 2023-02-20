package com.blog.domain.article.repository;

import static com.blog.domain.article.entity.QArticle.article;

import com.blog.domain.article.entity.Article;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepositoryCustom{

  private final JPAQueryFactory jpaQueryFactory;

  public ArticleRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
    this.jpaQueryFactory = jpaQueryFactory;
  }

  @Override
  public List<Article> findArticleWithReviewes(String reviewTitle) {
    return jpaQueryFactory.selectFrom(article)
        .where(article.review.reviewDetail.likeCount.between(1L, 10L))
        .fetch();
  }
}
