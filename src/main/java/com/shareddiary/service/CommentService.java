package com.shareddiary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.shareddiary.dto.CommentDto;
import com.shareddiary.mapper.CommentMapper;

public class CommentService {

	@Autowired
	private CommentMapper commentMapper;

	public void addComment(CommentDto comment) {
		commentMapper.addComment(comment);
	}

	public ArrayList<CommentDto> getCommentList(int diaryId){
		ArrayList<CommentDto> commentList=commentMapper.getCommentList(diaryId);
		return commentList;
	}
}
