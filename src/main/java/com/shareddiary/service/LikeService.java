package com.shareddiary.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.shareddiary.mapper.LikeMapper;

public class LikeService {

	@Autowired
	private LikeMapper likeMapper;

	//좋아요 추가 또는 취소
	public void changeLike(String user_id,int diary_id) {
		int checkLike= likeMapper.getLike(user_id, diary_id);
		//존재하지않음
		if(checkLike==0) {
			likeMapper.addLike(user_id, diary_id);
		}else if(checkLike==-1) { //취소함
			likeMapper.reLike(user_id, diary_id);
		}else {
			likeMapper.cancelLike(user_id, diary_id);
		}
	}


	//좋아요 여부 반환
	public boolean isLike(String user_id,int diary_id) {
		int checkLike= likeMapper.getLike(user_id, diary_id);
		if(checkLike==0 || checkLike==-1) {
			return false;
		}
		return true;
	}
}
