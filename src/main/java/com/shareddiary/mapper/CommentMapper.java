package com.shareddiary.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shareddiary.dto.CommentDto;

@Repository
@Mapper
public interface CommentMapper {
	//List<CamelCaseMap> selectUser();

	//댓글 작성
	public void addComment(@Param("commentDto")CommentDto commentDto);

	//다이어리에 달린 댓글 리스트 가져오기
	public ArrayList<CommentDto> getCommentList(@Param("diaryId")Integer diaryId);
}
