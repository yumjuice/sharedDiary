package com.shareddiary.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shareddiary.dto.DiaryDto;

@Repository
@Mapper
public interface DiaryMapper {
	///다이어리 id에 맞는 다이어리 객체 가져오기
	public DiaryDto getDiary(@Param("diaryId")Integer diaryId);

	//참여하고 있는 모든 방의 글의 페이지 수 (한 페이지에 글 6개 기준)
	public int getPageNum(@Param("userId")String userId);

	//방 id별로 글 리스트 가져오기
	public ArrayList<DiaryDto> getDiaryList(@Param("roomId")Integer roomId);

	//전체다이어리를 페이지넘버별로 가져오기
	public ArrayList<DiaryDto> getDiaryByPage(@Param("firstDiary")int firstDiary, @Param("userId")String userId);

	//다이어리 추가
	public void addDiary(@Param("diary")DiaryDto diary);

	//다이어리 삭제
	public void deleteDiary(@Param("diary")DiaryDto diary, @Param("userId")String userId);

	//다이어리 수정
	public void updateDiary(@Param("diary")DiaryDto diary);

	//방 안에 있는 모든 다이어리 삭제
	public void deleteDiaryList(@Param("roomId")Integer roomId, @Param("userId")String userId);

	//좋아요한 다이어리 리스트 가져오기
	public ArrayList<DiaryDto> getLikeDiaryList(@Param("userId")String userId);



}
