package com.letter.ggachi.repository.member;

import com.letter.ggachi.common.exception.MemberException;
import com.letter.ggachi.common.exception.type.ErrorCode;
import com.letter.ggachi.domain.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    List<Member> members = new ArrayList<>();
    for (int i = 1; i < 20; i++) {
      Member memberEntity = Member.builder()
        .nickname("yhj" + i)
        .name("유희준" + i)
        .email("yhj" + i + "@naver.com")
        .password("1234")
        .phoneNumber("01082003855")
        .introduction("")
        .build();
      members.add(memberEntity);
    }
    memberRepository.saveAll(members);

//    postEntity =
//      Post.builder()
//        .startDate(LocalDateTime.now())
//        .endDate(LocalDateTime.of(2024,2,20, 12, 10) )
//        .postEnc("")
//        .title("제목")
//        .member(memberEntity)
//        .build();
  }

  @Test
  @DisplayName("중복 이메일 검사")
  void existsByEmail() {
    String email = "yhj1@naver.com";
    assertThat(memberRepository.existsByEmail(email)).isEqualTo(true);
  }

  @Test
  @DisplayName("중복 닉네임 검사")
  void existsByNickName() {
    String nickname = "yhj1";
    assertThat(memberRepository.existsByNickname(nickname)).isEqualTo(true);
  }

  @Test
  @DisplayName("아이디로 조회")
  void findById() {
    Optional<Member> member = memberRepository.findById(1L);
    assertThat(member.orElseThrow(() -> new MemberException(ErrorCode.INVALID_MEMBER_ID)).getNickname()).isEqualTo("yhj1");
  }

  @Test
  void findByNickName() {
    String nickname = "yhj12";
    Optional<Member> member = memberRepository.findByNickname(nickname);
    assertThat(member.orElseThrow(() -> new MemberException(ErrorCode.INVALID_NICKNAME)).getEmail()).isEqualTo("yhj12@naver.com");

    nickname = "12";
    Optional<Member> member2 = memberRepository.findByNickname(nickname);
    assertThatThrownBy(
      () -> member2.orElseThrow(() -> new MemberException(ErrorCode.INVALID_NICKNAME))
    ).isInstanceOf(MemberException.class)
      .hasMessageContaining(ErrorCode.INVALID_NICKNAME.getMessage());
  }
}