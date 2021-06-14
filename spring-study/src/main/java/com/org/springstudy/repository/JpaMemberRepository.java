package com.org.springstudy.repository;

import com.org.springstudy.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    // EntityManager 인스턴스를 관리하는 것
    //JPA는 EntityManager로 동작
    //spring boot에서 객체 생성 생성자 주입
    private final EntityManager em;

    @Autowired
    public JpaMemberRepository(EntityManager em){

        this.em=em;
    }

    @Override
    public Member Save(Member member) {
        em.persist(member);
        //데이터베이스에 저장, setId()도 수행
        //entityManager.persist(entity);  // 엔티티를 영속성 컨텍스트에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member=em.find(Member.class, id);
        //엔티티 조회(조회할 (객체)타입, 식별자)
        //pk조회
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name= :name", Member.class)
                .setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from member m", Member.class).getResultList();
        return result;//select m: 객체를 조회
    }
}
/*
em.find();    // 엔티티 조회
em.persist(); // 엔티티 저장
em.remove();  // 엔티티 삭제
em.flush();   // 영속성 컨텍스트 내용을 데이터베이스에 반영
em.detach();  // 엔티티를 준영속 상태로 전환
em.merge();   // 준영속 상태의 엔티티를 영속상태로 변경
em.clear();   // 영속성 컨텍스트 초기화
em.close();   // 영속성 컨텍스트 종료
 */