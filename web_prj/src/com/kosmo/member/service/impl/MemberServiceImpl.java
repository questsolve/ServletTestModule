package com.kosmo.member.service.impl;

import java.util.List;

import com.kosmo.member.MemberVO;
import com.kosmo.member.service.MemberDAO;
import com.kosmo.member.service.MemberService;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		System.out.println(this.getClass().getSimpleName()+"Created");
		memberDAO = new MemberDAOImpl();
	}

	@Override
	public int insertMember(MemberVO vo) {
		return memberDAO.insertMember(vo);
		
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}

	public List<MemberVO> listMember(){
		return memberDAO.listMember();
	}
	
	public MemberVO select(int seq) {
		return memberDAO.select(seq);
	}
	
	public int update(MemberVO vo) {
		return memberDAO.update(vo);
	}
	
}
