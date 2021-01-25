package com.shareddiary.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class AccountViewController {

    @GetMapping(value={"/login",""})
    public ModelAndView loginView(ModelAndView modelAndView) {
        modelAndView.setViewName("auth/login");
        return modelAndView;
    }

    @GetMapping("/join")
    public ModelAndView JoinView(ModelAndView modelAndView) {
        modelAndView.setViewName("auth/join");
        return modelAndView;
    }
}
