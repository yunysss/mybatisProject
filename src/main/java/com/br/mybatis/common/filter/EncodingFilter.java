package com.br.mybatis.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */
/*
 * 필터클래스를 등록시키는 방법 2가지 (둘중에 하나만)
 * 1) web.xml에 등록하는 방법
 * 		> 현재 필터클래스 등록 후, 어떤 url로 요청시 해당 필터클래스를 거쳐가게 할 것인지 등록
 * 
 * 2) 어노테이션을 이용하는 방법
 * 		> 필터클래스 위에 @WebFilter 어노테이션을 활용해서 어떤 url로 요청시 거쳐가게 할 것인지 등록
 */
@WebFilter(filterName="encodingFilter", urlPatterns="/*")
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 요청전송방식이 post 또는 POST 일 경우 인코딩 작업
		if(((HttpServletRequest)request).getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		chain.doFilter(request, response);
		// 만약 다른 필터가 있다면 다른 필터를 실행시켜주는 용도
		// 다른 필터가 없다면 본격적으로 실행될 Servlet을 구동시켜주는 용도
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
