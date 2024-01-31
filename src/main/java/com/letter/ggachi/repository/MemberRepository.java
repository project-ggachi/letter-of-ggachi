package com.letter.ggachi.repository;

import com.letter.ggachi.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  @Query("SELECT m FROM Member m WHERE m.nickname = :nickname")
  Member findByNickname(String nickname);
}

