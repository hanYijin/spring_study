package com.org.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /*
    * MVC: Model, View, Controller
    * helloController 
    * viewResolver 동작하여 resource/templates/hello-template.html(Thymeleaf 템플릿 엔진처리)
     */
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "한이진님");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    /*
     * @ResponseBody 를 사용
     * HTTP의 BODY에 문자 내용을 직접 반환
     * ViewResolver 대신 HttpMessageConverter 가 동작
     * 기본 문자처리: StringHttpMessageConverter
     * 기본 객체처리: MappingJason2HttpMessageConverter
     */
    //API @ResponseBody 문자반환
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "<h1>hello</h2>" + "<p>"+name+"</P>";
    }
   //API @ResponseBody 객체반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);  //json 방식 {"키":"값"}
        return hello;
        //기본적으로 객체가 전달되면 JsonConverter이 동작
        //문자열은 StringConverter이 동작
    }
/*
* xml <태그></태그>
* json {"키":"값"}
* spring 기본적으로 객체를 전달하게 되면  json 방식으로 반환 
 */
    public class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
