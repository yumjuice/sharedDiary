package com.shareddiary.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/diary")
public class DiaryViewController {

	/*
	 * //다이어리 작성 페이지
	 *
	 * @GetMapping("/write") public ModelAndView writeDiaryView(ModelAndView
	 * modelAndView) { modelAndView.setViewName("diary/writediary"); return
	 * modelAndView; }
	 *
	 * //다이어리 수정 페이지
	 *
	 * @GetMapping("/{diaryid}/edit") public ModelAndView editDiaryView(ModelAndView
	 * modelAndView) { modelAndView.setViewName("diary/editdiary"); return
	 * modelAndView; }
	 *
	 * //다이어리 상세 페이지
	 *
	 * @GetMapping("/{diaryid}") public ModelAndView diaryView(ModelAndView
	 * modelAndView) { modelAndView.setViewName("diary/diarydetail"); return
	 * modelAndView; }
	 */
}

