package com.org.springstudy.repository;

import com.org.springstudy.domain.Member;

import java.util.List;
import java.util.Optional;
//회원 리포지토리 인터페이스
public interface MemberRepository {
    Member Save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
