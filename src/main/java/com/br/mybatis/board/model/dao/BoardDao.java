package com.br.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.board.model.vo.Reply;
import com.br.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectListCount(SqlSession sqlSession, PageInfo pi){
		
		// 마이바티스에서는 페이징 처리를 위해 RowBounds 클래스 제공
		// RowBounds 객체 생성시 "몇 개의 게시글을 건너뛰고" "몇개"를 조회할것인지 제시
		// * offset : 몇개의 게시글을 건너뛸 것인지에 대한 값
		// * limit : 몇개의 게시글을 조회할 것인지
		/*
		 * ex) boardLimit : 5
		 * 								offset(건너뛸숫자)		limit(조회할숫자)
		 * currentPage : 1		1~5				0					5
		 * currentPage : 2		6~10			5					5
		 * currentPage : 3		11~15			10					5
		 * ...
		 */
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	
	}
	
	public int insertBoard(SqlSession sqlSession, Board b) {
		return sqlSession.insert("boardMapper.insertBoard", b);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public Board boardHasOneMember(SqlSession sqlSession) {
		return sqlSession.selectOne("sampleMapper.boardHasOneMember");
	}
	
	public Board boardHasManyReply(SqlSession sqlSession) {
		return sqlSession.selectOne("sampleMapper.boardHasManyReply");
	}
	
	public ArrayList<Board> boardList(SqlSession sqlSession){
		return (ArrayList)sqlSession.selectList("sampleMapper.boardList");
	}

}
