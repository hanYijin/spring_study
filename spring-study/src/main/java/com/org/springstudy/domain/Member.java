package com.org.springstudy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//JPA 엔티티 매핑
//ORM(Object Relational Mapping) 겍체와 관계형데이터베이스의  매핑
@Entity
public class Member {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id DB에서 자동생성
    private Long id;
    /*
    만약에 DB 칼럼명이 username일 경우
    @Column(name="username")
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
