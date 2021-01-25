package com.shareddiary.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shareddiary.dto.MemberDto;

@Repository
@Mapper
public interface MemberMapper {
	//회원추가
	public void addMember(@Param("member")MemberDto member);

	//해당 id의 유저VO 반환
	public MemberDto getUser(@Param("user_id")String user_id);

	//방id넣으면 참여중인 유저 객체 출력
	public ArrayList<MemberDto> getMemberList(@Param("room_id")Integer room_id);

	//유저 정보 수정
	public void updateMember(@Param("member")MemberDto member);

}
