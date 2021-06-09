package com.org.springstudy.service;

import com.org.springstudy.domain.Member;
import com.org.springstudy.repository.MemberRepository;
import com.org.springstudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemeberService {

    private final MemberRepository memberRepository;
/*
    private  MemberRepository memberRepository= new MemberRepository(); 직접 객체 생성하지 않고
    외부에서 객체 생성하여 매개변수(파라미터)로 전달
    Dependency Injection 의존주입 : DI를 통한 의존 처리
* */
    //@Autowired
    public MemeberService(MemberRepository memberRepository){
        this.memberRepository= memberRepository;
    }
    //회원가입
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원X
        serechDataMember(member);//중복 회원 검증
        memberRepository.Save(member);
        return member.getId();
    }

    private void serechDataMember(Member member) {
        Optional<Member> result= memberRepository.findByName(member.getName());
        result.ifPresent(name->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
             /*
        memberRepository.findByName(member.getName())
                .ifPresent(neme->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
         */
        });
    }
    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);

    }
}
