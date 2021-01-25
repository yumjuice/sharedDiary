package com.shareddiary.dto;

import lombok.Data;

@Data
public class CommentDto {
	private String commentId;
	private String userId;
	private String diaryId;
	private String context;
	private String writerName;
}
