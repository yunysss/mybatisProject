package com.br.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.br.mybatis.common.template.Template.*;
import com.br.mybatis.member.model.dao.MemberDao;
import com.br.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDao mDao = new MemberDao();
	
	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = /*Template.*/getSqlSession();
		int result = mDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		SqlSession sqlSession = getSqlSession();
		int result = mDao.updateMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public int deleteMember(String userId) {
		return 0;
	}

}
