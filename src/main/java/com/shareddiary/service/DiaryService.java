package com.shareddiary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareddiary.dto.DiaryDto;
import com.shareddiary.mapper.DiaryMapper;

@Service
@Transactional
public class DiaryService {
	@Autowired
	private DiaryMapper diaryMapper;

	//diary id에 해당하는 다이어리 가져오기
	public DiaryDto getDiary(int diary_id) {
		DiaryDto diary=diaryMapper.getDiary(diary_id);
		return diary;
	}

	//페이지별 다이어리 리스트 가져오기
	public ArrayList<DiaryDto> getDiaryByPage(int page,String user_id){
		ArrayList<DiaryDto> list = diaryMapper.getDiaryByPage((page-1)*6, user_id);
		return list;
	}

	/***
	 * 페이지 수 반환
	 * @param user_id
	 * @return
	 */
	public int getPageNum(String user_id) {
		return diaryMapper.getPageNum(user_id);
	}

	//방에 해당하는 다이어리 리스트 반환
	public ArrayList<DiaryDto> getDiaryList(int room_id){
		ArrayList<DiaryDto> list = diaryMapper.getDiaryList(room_id);
		return list;
	}

	//다이어리 생성
	public void addDiary(DiaryDto diary) {
		diaryMapper.addDiary(diary);
	}

	//다이어리 삭제
	public void deleteDiary(DiaryDto diary,String user_id) {
		diaryMapper.deleteDiary(diary,user_id);
	}

	//다이어리 수정
	public void updateDiary(DiaryDto diary) {
		diaryMapper.updateDiary(diary);
	}

	//방 삭제할 때 방에 해당하는 모든 다이어리 삭제
	public void deleteDiaryList(int room_id,String user_id) {
		diaryMapper.deleteDiaryList(room_id,user_id);
	}

	//좋아요한 다이어리 리스트 반환
	public ArrayList<DiaryDto> getLikeDiaryList(String user_id){
		ArrayList<DiaryDto> list = diaryMapper.getLikeDiaryList(user_id);
		return list;
	}


}
