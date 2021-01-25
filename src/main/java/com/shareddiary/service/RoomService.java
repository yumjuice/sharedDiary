package com.shareddiary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareddiary.dto.MemberDto;
import com.shareddiary.dto.RoomDto;
import com.shareddiary.mapper.RoomMapper;


@Service
@Transactional
public class RoomService {

	@Autowired
	private RoomMapper roomMapper;


	/**
	 * 해당 유저가 참여하는 방 리스트 반환
	 * @param user_id
	 * @return
	 */
	public ArrayList<RoomDto> getRoomList(String userId){

		return roomMapper.getRoomList(userId);
	}

	/**
	 * 방정보 반환
	 * @param room_id
	 * @return
	 */
	public RoomDto getRoom(Integer roomId) {
		return roomMapper.getRoom(roomId);
	}

	/**
	 * 방추가
	 * @param user_id
	 * @param room
	 * @param userList
	 */
	public void addRoom(String userId, RoomDto room,List<String> userList) {
		int roomId=roomMapper.getLastId()+1;
		room.setRoomId(roomId);
		roomMapper.addRoom(room, userId);
		roomMapper.addRoomUser(room, userList, userId);
	}

	/**
	 * 방수정
	 * @param user_id
	 * @param room
	 * @param addFriendList
	 * @param removeFriendList
	 */
	public void updateRoom(String userId, RoomDto room,List<String> addFriendList,List<String> removeFriendList) {
		roomMapper.updateRoom(room, userId);
		List<String> newFriendList=new ArrayList<String>();
		for (int i=0;i<addFriendList.size();i++) {
			//이미 존재했던 사람이면
			if(roomMapper.checkUserExistsRoom(room.getRoomId(), addFriendList.get(i))!=null) {
				roomMapper.reAddRoomUser(room, addFriendList.get(i),userId);
			}else {
				newFriendList.add(addFriendList.get(i));
			}
		}
		if(newFriendList.size()>=1) {
			System.out.println("size"+newFriendList.size());
			System.out.println("newFriendList");
			System.out.println(newFriendList);
			roomMapper.addUserList(room,newFriendList, userId);

		}
		if(removeFriendList.size()>=1) {
			System.out.println("rmoveFriendlist"+removeFriendList);
			roomMapper.removeRoomUser(room.getRoomId(),removeFriendList,userId);
		}
	}

	/**
	 * 방에 해당 유저가 참여하는지 확인
	 * @param room_id
	 * @param user_id
	 * @return
	 */
	public boolean checkUserInRoom(Integer roomId,String userId) {
		if(roomMapper.checkUserInRoom(roomId, userId)!=null) return true;
		else return false;
	}


	/**
	 * 방삭제
	 * @param user_id
	 * @param room_id
	 * @param memberList
	 */
	public void deleteRoom(String userId, Integer roomId, ArrayList<MemberDto> memberList) {

		roomMapper.deleteRoom(userId, roomId);
		List<String> userList=new ArrayList<String>();
		for(int i=0;i<memberList.size();i++) {
			userList.add(memberList.get(i).getUserId());
		}
		roomMapper.removeRoomUser(roomId, userList, userId);
	}
	/**
	 * 방 탈퇴
	 * @param user_id
	 * @param room_id
	 */
	public void deleteRoomUser(String userId, Integer roomId) {
		String masterId=roomMapper.getRoom(roomId).getMasterId();

		int count=roomMapper.getCountOfParti(roomId);
		//방에 참여자가 본인 한명이라면 방 삭제
		if(count==1) {
			roomMapper.deleteRoomUser(userId, roomId);
		}
		//탈퇴한 사람이 방장이라면 가장 먼저 추가된 사람에게 방장 이관하고 탈퇴
		else if(masterId.equals(userId)) {

			roomMapper.updateMaster(roomId, userId);
			roomMapper.deleteRoomUser(userId, roomId);
		}//탈퇴
		else roomMapper.deleteRoomUser(userId, roomId);
	}

}
