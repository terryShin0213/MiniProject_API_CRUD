package com.blog.domain.board.vo;

import java.util.UUID;
import lombok.Getter;

@Getter
public class BoardWithAriticle {
  private final UUID boardId;
  private final String boardName;
  private final UUID articleId;
  private final String articleTitle;
  private final String articleContents;
  private final String articleImageUrl;

  public BoardWithAriticle(UUID boardId, String boardName, UUID articleId, String articleTitle,
      String articleContents, String articleImageUrl) {
    this.boardId = boardId;
    this.boardName = boardName;
    this.articleId = articleId;
    this.articleTitle = articleTitle;
    this.articleContents = articleContents;
    this.articleImageUrl = articleImageUrl;
  }
}
