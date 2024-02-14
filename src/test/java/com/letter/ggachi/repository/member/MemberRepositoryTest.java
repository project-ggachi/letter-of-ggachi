package com.letter.ggachi.repository.member;

import com.letter.ggachi.domain.entity.Member;
import com.letter.ggachi.domain.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  void setUp() {
    Member member = Member.builder().nickName("yhj3855").name("유희준").email("yhj3855@naver.com").password("1234").phoneNumber("01082003855").introduction("").build();
    memberRepository.save(member);

    Post post = Post.builder().
  }

  @Test
  void existsByEmail() {
  }

  @Test
  void existsByNickName() {
  }

  @Test
  void findById() {
  }

  @Test
  void findAllByNickNameContaining() {
  }

  @Test
  void findByNickName() {
  }
}