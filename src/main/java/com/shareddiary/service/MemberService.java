package com.shareddiary.service;

import java.util.ArrayList;

import com.shareddiary.dto.MemberDto;

public interface MemberService {
	//멤버추가
	public boolean addMember(MemberDto member) throws Exception;

	//방에 참여하는 멤버객체 반환
	public ArrayList<MemberDto> memberList(int room_id) throws Exception;

	//id에 해당하는 멤버객체 반환
	public MemberDto getMember(String user_id) throws Exception;

	//id가 존재하는지 확인
	public boolean checkUserExist(String id) throws Exception;

	//멤버 수정
	public void updateMember(MemberDto member) throws Exception;


}

