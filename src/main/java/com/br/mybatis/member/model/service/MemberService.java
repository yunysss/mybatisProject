package com.br.mybatis.member.model.service;

import com.br.mybatis.member.model.vo.Member;

public interface MemberService {
	
	// 인터페이스의 모든 메소드는 묵시적으로 public abstract(추상메소드==미완성메소드)
	
	// 1. 회원가입서비스
	int insertMember(Member m);
	
	// 2. 로그인서비스
	// Member loginMember(String userId, String userPwd);
	Member loginMember(Member m);
	
	// 3. 회원정보수정서비스
	int updateMember(Member m);
	
	// 4. 회원탈퇴서비스
	int deleteMember(String userId);

}
