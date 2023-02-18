package com.blog.controller.dto;

import com.blog.domain.board.vo.BoardWithAriticle;
import java.util.UUID;
import lombok.Getter;

@Getter
public class BoardWithArticleResponse {

  private UUID boardId;
  private String boardName;
  private UUID articleId;
  private String articleTitle;
  private String articleContents;
  private String articleImageUrl;

  public static BoardWithArticleResponse from(BoardWithAriticle boardWithAriticle) {
    return new BoardWithArticleResponse(boardWithAriticle);
  }

  public BoardWithArticleResponse(BoardWithAriticle boardWithAriticle) {
    this.boardId = boardWithAriticle.getBoardId();
    this.boardName = boardWithAriticle.getBoardName();
    this.articleId = boardWithAriticle.getArticleId();
    this.articleTitle = boardWithAriticle.getArticleTitle();
    this.articleContents = boardWithAriticle.getArticleContents();
    this.articleImageUrl = boardWithAriticle.getArticleImageUrl();
  }
}
