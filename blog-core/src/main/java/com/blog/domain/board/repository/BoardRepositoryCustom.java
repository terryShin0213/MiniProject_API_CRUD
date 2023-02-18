package com.blog.domain.board.repository;

import com.blog.domain.board.vo.BoardWithAriticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
  Page<BoardWithAriticle> findBoardWithArticle(Pageable pageable);
}
