package com.org.springstudy.controller;

import com.org.springstudy.domain.Member;
import com.org.springstudy.service.MemeberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
spring 컨테이너가 @Controller 어노테이션을 있는 객체를 생성하여 넣어둔다
spring 컨테이너에서 스프링 빈이 관리
스프링 빈을 등록할때, 기본으로 싱글톤으로 등록한다 따라서 같은 스프링 빈이면 모두 같은 인스턴스이다
 */
@Controller
public class MemberController {
    private final MemeberService memeberService;
/*
생성자에 @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에 찾아서 넣어준다.
객체 의존관계를 외부에서 넣어주는 것을 DI, 의존성 주입
@Autowired 에 의해 스프링 주입을 해줌

컴포넌트 스캔과 자동 의존관계 설정
@Controller, @Service, @Repository 는 @Component 에 포함되는 어노테이션
@Component 어노테이션이 있으면 스프링 빈으로 생성하여 자동으로 spring 컨테이너에 등록
@Autowired는 객체가의 연관관계를 연결하는 어노테이션
정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용
 */
    /*
     DI에는 3가지 방법이 있다
     1. 필드 주입
     2. setter 주입
     3. 생성자 주입(권장)
     */
    //1. 필드 주입
    //@Autowired private MemberService memeberService;

    //2.setter 주입
    //private MemeberService memeberService;
    //@Autowired
    //public void setMemberSerivce(MemeberService memeberService) {
    //        this.memeberService = memeberService;
    //    }

    @Autowired //3. 생성자 주입
    public MemberController(MemeberService memeberService) {
        this.memeberService = memeberService;
    }
    //회원 가입
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member memeber= new Member();
        memeber.setName(form.getName());
        memeberService.join(memeber);
        return "redirect:/";
    }
    //회원 목록 조회
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members=memeberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
