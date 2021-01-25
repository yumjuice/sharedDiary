package com.shareddiary.dto;

import lombok.Data;

@Data
public class LikeDto {
	private int likeId;
	private String userId;
	private int diaryId;
	private String use_yn;
}
