package com.org.springstudy.service;

import com.org.springstudy.domain.Member;
import com.org.springstudy.repository.MemberRepository;
import com.org.springstudy.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Transactional
/*
@SpringBootTest : 스프링 컨데이너와 테스트를 함께 실행

@Transactional: 테스트케이스에 이 어노테이션이 있으면, 테스크 시작 전에 트랜잭션을 시작하고,
테스트 완료 후에 항상 롤백!! DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는 다.
 */
// 스프링 컨테이너와 DB 연결한 통합 테스트
class MemeberServiceIntegrationTest {
    @Autowired
    MemeberService memeberService;
    @Autowired
    MemberRepository memberRepository;

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