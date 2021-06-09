package com.org.springstudy;

import com.org.springstudy.repository.JdbcMemberRepository;
import com.org.springstudy.repository.MemberRepository;
import com.org.springstudy.repository.MemoryMemberRepository;
import com.org.springstudy.service.MemeberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
자바 코드로 직접 스프링 빈 등록하기
정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정(@Configuration)을 통해 스프링 빈을 등록
Assembler 조립한다
 */
@Configuration
public class SpringConfig {
    //@Autowired
    //private DataSource dataSource;
/*
javax.sql.DataSource 인터페이스는 Database Connection을 위한 standard method를 제공한다.
DataSource 인터페이스를 사용하기 위한 구현체를 선택해야 하는데,
spring-boot-starter-jdbc 를 추가하면 Spring Boot에서는 DataSource 관리를 위한 구현체로써 tomcat-jdbc을 default로 제공한다.

DataSource 의 설정은 application.properties 파일내에서 spring.datasource.* 와 같은 패턴으로 설정이 가능
 */
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Bean
    public MemeberService memeberService(){

        return new MemeberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){

        return new JdbcMemberRepository(dataSource);
    }
}
