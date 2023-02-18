package com.blog.service;

import com.blog.controller.dto.BoardWithArticleResponse;
import com.blog.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  @Override
  public Page<BoardWithArticleResponse> findBoardWithArticleResponseByPaging(Pageable pageable) {
    return boardRepository.findBoardWithArticle(pageable).map(boardWithAriticle ->
        BoardWithArticleResponse.from(boardWithAriticle));
  }
}
