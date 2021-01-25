package com.shareddiary.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface LikeMapper {

	//좋아요 확인 0: 존재하지않음 1: 좋아요 중 -1:좋아요 취소함
	public int getLike(@Param("userId")String userId, @Param("diaryId")Integer diaryId);
	//좋아요 추가
	public void addLike(@Param("userId")String userId, @Param("diaryId")Integer diaryId);
	//좋아요 재 추가
	public void reLike(@Param("userId")String userId, @Param("diaryId")Integer diaryId);
	//좋아요 취소
	public void cancelLike(@Param("userId")String userId, @Param("diaryId")Integer diaryId);

}
