package com.shareddiary.service.impl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareddiary.dto.MemberDto;
import com.shareddiary.mapper.MemberMapper;
import com.shareddiary.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {


	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberMapper memberMapper;

	 // 회원 추가
	@Override
	public boolean addMember(MemberDto member) throws Exception {
		String encodedPassword=passwordEncoder.encode(member.getUserPw());
		member.setUserPw(encodedPassword);

		//일치하는 아이디가 없을 시
		if(memberMapper.getUser(member.getUserId())==null) {
			//회원정보 추가
			memberMapper.addMember(member);
			return true;
		};
		//일치하는 아이디가 있을 시 실패반환
		return false;

	}

	/***
	 * 방에 참여중인 멤버 리스트 반환
	 */
	@Override
	public ArrayList<MemberDto> memberList(int roomId) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.getMemberList(roomId);
	}

	/**
	 * id에 해당하는 멤버 객체 반환
	 */
	@Override
	public MemberDto getMember(String user_id) throws Exception {
		// TODO Auto-generated method stub

		return memberMapper.getUser(user_id);
	}


	/**
	 * id가 존재하는지 확인
	 */
	@Override
	public boolean checkUserExist(String id) throws Exception {
		// TODO Auto-generated method stub
		if(memberMapper.getUser(id)==null) {
			return false;
		}
		return true;
	}

	/**
	 * 유저 정보 수정
	 */
	@Override
	public void updateMember(MemberDto member) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.updateMember(member);
	}

}
