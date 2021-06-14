package com.org.springstudy.repository;

import com.org.springstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//extends JpaRepository<객체 타입, pk 타입>
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {
    @Override
    //JPQL select m from Member m where m.name =?
    Optional<Member> findByName(String name);
    //인터페이스의 메소드 이름만으로도 조회 기능 제공(쿼리문을 자동으로 생성)
    //findByNameAndID(String name, Long id);
}
