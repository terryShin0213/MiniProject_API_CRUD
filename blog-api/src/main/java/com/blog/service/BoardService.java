package com.blog.service;

import com.blog.controller.dto.BoardWithArticleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
  Page<BoardWithArticleResponse> findBoardWithArticleResponseByPaging(Pageable pageable);
}
