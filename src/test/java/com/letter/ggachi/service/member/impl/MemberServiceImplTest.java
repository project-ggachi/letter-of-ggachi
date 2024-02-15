package com.letter.ggachi.service.member.impl;

import com.letter.ggachi.common.exception.MemberException;
import com.letter.ggachi.common.exception.type.ErrorCode;
import com.letter.ggachi.domain.dto.request.MemberLoginRequest;
import com.letter.ggachi.domain.dto.request.MemberSignUpRequest;
import com.letter.ggachi.domain.dto.response.MemberLoginResponse;
import com.letter.ggachi.domain.dto.response.ValidateInfoResponse;
import com.letter.ggachi.domain.entity.Member;
import com.letter.ggachi.repository.member.MemberRepository;
import com.letter.ggachi.service.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of MemberService
 *
 * @author :uheejoon
 * @fileName :MemberServiceImplTest
 * @since :2024-02-15 오전 9:57
 */

@SpringBootTest
@Transactional @Commit
class MemberServiceImplTest {

  @Autowired
  MemberRepository memberRepository;
  @Autowired
  MemberService memberService;
  @Autowired
  PasswordEncoder passwordEncoder;

  Member member;
  @BeforeEach
  void setUp() {
    memberRepository.deleteAll();
    member = Member.builder()
      .nickname("uheejoon")
      .name("유희준")
      .phoneNumber("01082003855")
      .password("1234")
      .email("yhj3855@naver.com")
      .posts(new ArrayList<>())
      .letters(new ArrayList<>())
      .build();
    memberService.join(MemberSignUpRequest.from(member));
  }

  @Test
  @DisplayName("회원가입")
  void join() {
//    when
    Member member1 = memberRepository.findByNickname("uheejoon").get();
//    then
    assertTrue(passwordEncoder.matches("1234" ,member1.getPassword()));
  }

  @Test
  @DisplayName("로그인")
  void login() {
    MemberLoginResponse loginResponse = memberService.login(MemberLoginRequest.builder().email("yhj3855@naver.com").password("1234").build());
//    assertThrows(MemberException.class, () -> memberService.login(MemberLoginRequest.builder().email("yhj3855@naver.com").password("12345").build()));
//    assertThrows()
  }

  @Test
  @DisplayName("닉네임 중복 검사")
  public void validateNickname() {
    ValidateInfoResponse uheejoonInfo = memberService.validateNickname("uheejoon");
  }

  @Test
  @DisplayName("이메일 중복 검사")
  public void validateEmail() {
    ValidateInfoResponse uheejoonInfo = memberService.validateEmail("yhj3855@naver.com");

  }
}