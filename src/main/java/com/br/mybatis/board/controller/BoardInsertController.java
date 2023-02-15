package com.br.mybatis.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.mybatis.board.model.service.BoardServiceImpl;
import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청시 전달값 뽑기 (제목, 내용)
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 요청시 전달값 + 세션으로부터 로그인한 회원번호 => Board 객체 주섬주섬담기
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		Board b = new Board();
		b.setBoardContent(content);
		b.setBoardTitle(title);
		b.setCount(userNo);
		
		int result = new BoardServiceImpl().insertBoard(b);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/list.bo?cpage=1");
		} else {
			request.setAttribute("errorMsg", "작성실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
