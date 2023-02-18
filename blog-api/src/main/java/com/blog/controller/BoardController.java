package com.blog.controller;

import com.blog.controller.dto.BoardWithArticleResponse;
import com.blog.domain.article.entity.Article;
import com.blog.domain.article.repository.ArticleRepository;
import com.blog.service.BoardServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

  private final BoardServiceImpl boardService;

  private final ArticleRepository articleRepository;

  @GetMapping(path = "/boardAll")
  public Page<BoardWithArticleResponse> findBoardWithArticle(
      @PageableDefault(size = 20, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable
  ) {
    return boardService.findBoardWithArticleResponseByPaging(pageable);
  }

  @GetMapping(path = "/articleAll")
  public List<Article> findArticles() {
    return articleRepository.findAll();
  }

}
