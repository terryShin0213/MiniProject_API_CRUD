package com.blog.domain.article.entity;

import com.blog.common.entity.BaseTimeEntity;
import com.blog.domain.review.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Where;
import org.hibernate.type.SqlTypes;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Where(clause = "deleted = false")
public class Article extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private UUID boardId;
  private String title;
  private String content;
  private String imageUrl;

  @JdbcTypeCode(SqlTypes.JSON)
  private Review review;

  private Article(UUID boardId, String title, String content, String imageUrl) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.imageUrl = imageUrl;
  }

  public static Article of(UUID boardId, String title, String content, String imageUrl) {
    return new Article(boardId,title, content, imageUrl);
  }
}
