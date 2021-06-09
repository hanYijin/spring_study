package com.org.springstudy.repository;

import com.org.springstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository= new MemoryMemberRepository();
    // @AfterEach: 한번에 여러 테스트를 실행하면 메모리 DB애 직전 테스트의 결과가 남을 수 있다
    // 다음 테스트가 실패 가능성이 있으므로 @AfterEach를 사용하면 각 테스트가 종료될 때마다 이 기능을 실행
    // 테스트는 각각 독립적으로 실행
    // 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.
    @AfterEach //데스트가 종료될때 마다 메모리 DB에 저장된 데이터 삭제
    public void afterEech(){
        repository.clearStore();
    }
    @Test
    public void save(){
        //givenㄴ
        Member member = new Member();
        member.setName("gksdlwls123");
        //when
        repository.Save(member);
        Member result = repository.findById(member.getId()).get();
        //import org.assertj.core.api.Assertions;
        //Assertions.assertThat(member).isEqualTo(result);

        //import static org.assertj.core.api.Assertions.*;
        //then
        assertThat(member).isEqualTo(result);//

        //System.out.println("reuslt= "+ (result==member));

        //import org.junit.jupiter.api.Assertions;
        //Assertions.assertEquals(member, result);//member와 result 가 같은지 확인

        //Assertions.assertEquals(member, null);
        //org.opentest4j.AssertionFailedError:
        //Expected :com.org.springstudy.domain.Member@51399530
        //Actual   :null
        //<Click to see difference>
    }
    @Test
    public void findByName(){
        //given
        Member member1= new Member();
        member1.setName("spring1");
        repository.Save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.Save(member2);
        //when
        Member result = repository.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);

    }
    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.Save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.Save(member2);

        List<Member> result= repository.findAll();
        assertThat(result.size()).isEqualTo(2);

        //assertThat(result.size()).isEqualTo(3);
        /*
        org.opentest4j.AssertionFailedError:
        Expecting:
         <2>
        to be equal to:
        <3>
        but was not.
        Expected :3
        Actual   :2
         */
    }
}
