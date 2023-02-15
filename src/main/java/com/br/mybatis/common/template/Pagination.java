package com.br.mybatis.common.template;

import com.br.mybatis.common.model.vo.PageInfo;

public class Pagination {
	
	// 게시글총갯수, 요청한페이지수, pageLimit, boardLimit 가지고
	// 마지막페이지수, 페이징바시작수, 페이징바끝수 구해서 
	// PageInfo객체 담아서 반환 메소드
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		return new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
	}

}
