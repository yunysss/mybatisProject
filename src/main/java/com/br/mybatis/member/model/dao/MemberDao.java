package com.br.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		/*
		 * sqlSession에서 제공하는 메소드를 통해서
		 * sql문 찾아서 완성시킨 후 실행하고 결과 바로 받음
		 * 
		 * 결과 = sqlSession.sql문종류에맞는메소드("매퍼의별칭.sql문의고유id", [그sql문을완성시킬객체]);
		 */
		
		//int result = sqlSession.insert("memberMapper.insertMember", m);
		//return result;
		
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		// 결과 = sqlSession.sql메소드("매퍼.sql id", [전달할객체]);
		return sqlSession.selectOne("memberMapper.loginMember", m); // 조회결과 없으면 null
	}
	
	public int updateMember(SqlSession sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}

}
