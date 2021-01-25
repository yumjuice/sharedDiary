package com.shareddiary.dto;

import lombok.Data;

@Data
public class MemberDto {
	private String userId;
	private String userPw;
	private String userName;
	private String userBirth;
	private String userGender;
	private String userEmail;
}
