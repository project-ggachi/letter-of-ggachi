package com.letter.ggachi.repository;

import com.letter.ggachi.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {
  @Query("SELECT m FROM GGACHI_MEMBER m WHERE m.NICKNAME = :nickname")
  Member findByNickname(String nickname);
}

