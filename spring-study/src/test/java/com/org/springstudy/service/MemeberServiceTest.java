package com.org.springstudy.service;

import com.org.springstudy.domain.Member;
import com.org.springstudy.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
// 단위 테스트
class MemeberServiceTest {
    MemeberService memeberService;
    MemoryMemberRepository memberRepository;
    
    //@BeforEach : 각 테스트를 실행 전에 호출됨. 서로 영향이 없도록 항상 새로운 객체를 생성하고 의존관계도 새로 맺어줌
    @BeforeEach
    public void BeforeEach(){
        memberRepository = new MemoryMemberRepository();
        memeberService= new MemeberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() {
        //given(주어진 데이터)
        Member member = new Member();
        member.setName("한이진");
        //when(실행)
        Long saveId= memeberService.join(member);
        //then(결과)
        Member findMember= memeberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1= new Member();
        member1.setName("한이진");

        Member member2= new Member();
        member2.setName("한이진");

        //when
        memeberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,()->memeberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        try {
            memeberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
         */
        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}