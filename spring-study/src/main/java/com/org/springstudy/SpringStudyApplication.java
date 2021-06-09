package com.org.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@SpringBootApplication 은
@ComponentScan 어노테이션이 포함되어있다
그렇기 때문에 현재 com.org.springstudy 패기지 하위의 컴포넌트만 스프링 빈으로 객체 등록
 */
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
	}

}
