package com.org.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
HomeController 가 우선으로 실행
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String Home(){
        return "Home";
    }
}
