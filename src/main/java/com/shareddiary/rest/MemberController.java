package com.shareddiary.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shareddiary.dto.MemberDto;
import com.shareddiary.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	//회원추가
	@PostMapping
    public boolean addMember(@RequestBody MemberDto memberDto) throws Exception {
		boolean isIdDuplicate= memberService.addMember(memberDto);
        return isIdDuplicate;
    }

	//회원수정
    @PutMapping
	public boolean editMember(@RequestBody MemberDto memberDto) throws Exception {
    	memberService.updateMember(memberDto);
    	return true;
	}
}
