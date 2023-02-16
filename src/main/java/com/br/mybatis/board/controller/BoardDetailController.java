package com.br.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.mybatis.board.model.service.BoardServiceImpl;
import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.board.model.vo.Reply;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("no"));
		
		// 1. 조회수증가시키는 서비스 호출
		int result = new BoardServiceImpl().increaseCount(boardNo);
		
		if(result > 0) {
			Board b = new BoardServiceImpl().selectBoard(boardNo);
			ArrayList<Reply> rList = new BoardServiceImpl().selectReplyList(boardNo);
			
			request.setAttribute("b", b);
			request.setAttribute("rList", rList);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
		}
		// > 성공시
		//		2. 해당 게시글 상세 조회 서비스 호출
		//		3. 해당 게시글 딸린 댓글 리스트 조회 서비스 호출
		//		게시글객체, 댓글리스트객체 담아서 boardDetailView.jsp 포워딩
		// > 실패시
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
