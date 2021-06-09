package com.org.springstudy.repository;

import com.org.springstudy.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

//회원 리포지토리 메모리 구현체
//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence =0L; //시퀸스(0~ ), 키 값 생성
    @Override
    public Member Save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }
    /*
    * Optional는 “존재할 수도 있지만 안 할 수도 있는 객체”, 즉, “null이 될 수도 있는 객체”을 감싸고 있는 일종의 래퍼 클래스
    *  null을 담을 수 있는 특수한 그릇
     */
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //값이 null 일 경우가 있다면 ofNullable 메소드를 사용
        //optional은 null 반환되는 경우에도 감쌀 수 있다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
        //루프로 돌려 파라메타로 넘어오는 name이 같을 경우에만 filter .findAny() 찾으면 반환
        //없는 경우 (null) Optional
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());//values-> member
    }

    public void clearStore(){
        store.clear();// 저장된 메모리 데이터를 비움
    }
}
