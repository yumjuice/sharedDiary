package com.shareddiary.dto;

import lombok.Data;

@Data
public class DiaryDto {
	private int diaryId;
	private String writerId;
	private int roomId;
	private String roomName;
	private String writerName;
	private String title;
	private String feeling;
	private String context;
	private String imgaddr;
	private String date;
}
