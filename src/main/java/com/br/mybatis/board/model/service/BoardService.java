package com.br.mybatis.board.model.service;

import java.util.ArrayList;

import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.board.model.vo.Reply;
import com.br.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 조회 서비스
	int selectListCount();
	ArrayList<Board> selectList(PageInfo pi);
	
	// 게시글 작성 서비스
	int insertBoard(Board b);
	
	// 게시글 상세조회 서비스
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	ArrayList<Reply> selectReplyList(int boardNo);
	
	// 게시글 검색
	

}
