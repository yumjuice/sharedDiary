package com.shareddiary.web;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shareddiary.dto.DiaryDto;
import com.shareddiary.dto.MemberDto;
import com.shareddiary.dto.RoomDto;
import com.shareddiary.service.DiaryService;
import com.shareddiary.service.MemberService;
import com.shareddiary.service.RoomService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/user/board")
public class BoardViewController {

	@Autowired
	private MemberService memberService;
	private RoomService roomService;
	private DiaryService diaryService;

    @GetMapping
    public ModelAndView mainBoardView(ModelAndView modelAndView,Principal principal) throws Exception {
		/*
		 * 로그인 사용자 정보 MemberVO userVO
		 * 참여중인 Room객체 리스트 반환
		 * ArrayList<RoomVO> room_list
		 * 첫페이지다이어리리스트 ArrayList<DiaryVO> diary_list
		 * 좋아요리스트  ArrayList<DiaryVO> likeDiaryList
		 * 총 페이지 수 int total_page
		 *
		 */
    	//로그인 사용자 아이디
    	String userId = principal.getName();
    	MemberDto memberDto = memberService.getMember(userId);
    	//방 정보 가져오기
	    ArrayList<RoomDto> roomList=roomService.getRoomList(userId);
	    //첫번째 다이어리 리스트
	    ArrayList<DiaryDto> diaryList = diaryService.getDiaryByPage(0,userId);
	    //좋아요한 다이어리리스트가져오기
	    ArrayList<DiaryDto> likeDiaryList = diaryService.getLikeDiaryList(userId);
	    //총 페이지 수
    	int totalPage=diaryService.getPageNum(userId);



    	modelAndView.addObject("roomList", roomList);
    	modelAndView.addObject("diaryList", diaryList);
    	modelAndView.addObject("likeDiaryList", likeDiaryList);
    	modelAndView.addObject("pageNum", totalPage);
    	modelAndView.addObject("memberDto", memberDto);

    	log.info("memberDto: " + memberDto);
    	log.info("roomList: " + roomList);
    	log.info("diaryList: " + diaryList);
    	log.info("likeDiaryList: " + likeDiaryList);
    	log.info("totalPage: " + totalPage);

    	modelAndView.setViewName("auth/join");


        return modelAndView;
    }
/*
    @PutMapping("board/{boardIdx}")
    public void updateBoard(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx, @RequestBody Board board) throws Exception {
        board.setBoardIdx(boardIdx);
        this.boardService.updateBoard(request, board);
    }

    @GetMapping("/room/roomId")
    public ModelAndView roomBoardView(ModelAndView modelAndView) {
        modelAndView.setViewName("board/room");
        return modelAndView;
    }*/
}
