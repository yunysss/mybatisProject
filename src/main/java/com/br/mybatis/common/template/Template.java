package com.br.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*
	 * 기존 JDBCTemplate
	 * public static Connection getConnection(){
	 * 		// driver.properties 파일 읽어들여서
	 * 		// 해당 DB와 접속된 Connection 객체 생성해서 반환
	 * }
	 * 
	 * public static void close(JDBC용 객체){		=> 3개
	 * 		// 전달받은 JDBC용 객체를 반납시키는 구문
	 * }
	 * 
	 * public static commit|rollback(conn){
	 * 		// 트랜잭션 처리
	 * }
	 */
	
	public static SqlSession getSqlSession() {
		// mybatis-config.xml 파일 읽어들여서
		// 해당 DB와 접속된 SqlSession 객체 생성해서 반환
		SqlSession sqlSession = null;
		
		// mybatis-config.xml 파일을 읽어들이기 위한 입력용스트림 객체 생성
		try {
			InputStream stream = Resources.getResourceAsStream("/config/mybatis-config.xml"); // 첫번째 / : source퐅더들
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false); // true : 자동 commit / 기본값 false
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}

}
