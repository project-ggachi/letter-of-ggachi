package com.letter.ggachi.repository.member;

import com.letter.ggachi.domain.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  boolean existsByEmail(String email);
  // 닉네임 중복 여부 확인
  boolean existsByNickName(String nickname);

  Optional<Member> findById(Long id);

  Page<Member> findAllByNickNameContaining(String keyword, Pageable pageable);

  Optional<Member> findByNickName(String nickname);


}
