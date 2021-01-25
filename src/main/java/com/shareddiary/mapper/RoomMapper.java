package com.shareddiary.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shareddiary.dto.RoomDto;

@Repository
@Mapper
public interface RoomMapper {

	//사용자가 참여하는 방 리스트 반환
	public ArrayList<RoomDto> getRoomList(@Param("userId")String userId);

	//방 정보반환
	public RoomDto getRoom(@Param("roomId")Integer roomId);

	//마지막 room_id가져옴
	public int getLastId();

	//방추가
	public void addRoom(@Param("room")RoomDto room, @Param("userId")String userId);

	//방수정
	public void updateRoom(@Param("room")RoomDto room, @Param("userId")String userId);

	//방과 참여자들 추가
	/**
	 * 새로 만들어진 방에 유저 추가
	 * @param room
	 * @param userList
	 * @param userId
	 */
	public void addRoomUser(@Param("room")RoomDto room, @Param("userList")List<String> userList, @Param("userId")String userId);

	//이미 만들어진 방에 새로운 참여자들 추가
	public void addUserList(@Param("room")RoomDto room, @Param("userList")List<String> userList, @Param("user_id")String userId);

	//현재 방에 해당 유저가 있는지 확인
	public String checkUserInRoom(@Param("roomId")Integer roomId, @Param("userId")String userId);

	//유저가 해당 방에 존재했었는지 여부 확인
	public String checkUserExistsRoom(@Param("roomId")Integer roomId, @Param("userId")String userId);

	//방에서 탈퇴된 유저 다시 초대
	public void reAddRoomUser(@Param("room")RoomDto room, @Param("friend")String friend, @Param("userId")String userId);

	//방 삭제 --> 방에 참여하고 있는 유저 모두 탈퇴
	public void removeRoomUser(@Param("roomId")Integer roomId, @Param("removeFriendList")List<String> removeFriendList, @Param("userId")String userId);

	//방 삭제
	public void deleteRoom(@Param("userId")String userId, @Param("roomId")Integer roomId);

	//방탈퇴
	public void deleteRoomUser(@Param("userId")String userId, @Param("roomId")Integer roomId);

	//해당 방의 방장을 해당 id로 변환
	public void updateMaster(@Param("roomId")Integer roomId, @Param("userId")String userId);

	//해당 방에 참여자 수 반환
	public int getCountOfParti(@Param("roomId")Integer roomId);

}
