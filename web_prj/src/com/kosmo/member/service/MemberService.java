package com.kosmo.member.service;

import java.util.List;

import com.kosmo.member.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO vo);
	public MemberVO login(MemberVO vo);
	public List<MemberVO> listMember();
	public MemberVO select(int seq) ;
	public int update(MemberVO vo);
}
