package com.blog.domain.article.repository;

import com.blog.domain.article.entity.Article;
import java.util.List;

public interface ArticleRepositoryCustom {
  List<Article> findArticleWithReviewes(String reviewTitle);
}
