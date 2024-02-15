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
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.letter.ggachi.common.exception.type.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void join(MemberSignUpRequest request) {
    validateNicknameDuplication(request.getNickname());
    validateEmailDuplication(request.getEmail());

    memberRepository.save(
      Member.builder()
        .nickname(request.getNickname())
        .password(passwordEncoder.encode(request.getPassword()))
        .name(request.getName())
        .email(request.getEmail())
        .phoneNumber(request.getPhoneNumber())
        .introduction(request.getIntroduction())
      .build());
  }

  @Override
  public MemberLoginResponse login(MemberLoginRequest request) {
    Member member = getMemberByEmail(request.getEmail());

    if(!validatePasswordWithDB(request.getPassword(), member.getPassword())){
      throw new MemberException(MISMATCH_PASSWORD);
    }
    return MemberLoginResponse.fromEntity(member);
  }

  @Override
  @Transactional
  public ValidateInfoResponse validateNickname(String nickname) {
    return ValidateInfoResponse.builder()
      .isDuplicate(memberRepository.existsByNickname(nickname))
      .build();
  }

  @Override
  @Transactional
  public ValidateInfoResponse validateEmail(String email) {
    return ValidateInfoResponse.builder()
      .isDuplicate(memberRepository.existsByEmail(email))
      .build();
  }

  private void validateNicknameDuplication(String nickname) {
    Member member = memberRepository.findByNickname(nickname).orElse(null);
    if(member != null) {
      throw new MemberException(ALREADY_EXISTS_NICKNAME);
    }
  }
  private void validateEmailDuplication(String email) {
    Member member = memberRepository.findByNickname(email).orElse(null);
    if(member != null) {
      throw new MemberException(ALREADY_EXISTS_NICKNAME);
    }
  }

  private Member getMemberByEmail(String email) {
    return memberRepository.findByEmail(email).orElseThrow(() -> new MemberException(INVALID_EMAIL));
  }

  private boolean validatePasswordWithDB(String inputPassword, String encodedPassword){
    return passwordEncoder.matches(inputPassword, encodedPassword);
  }
}
