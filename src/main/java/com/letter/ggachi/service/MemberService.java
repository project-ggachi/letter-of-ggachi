package com.letter.ggachi.service;

import com.letter.ggachi.domain.entity.Member;
import com.letter.ggachi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  public Member save(Member member) {
    return memberRepository.save(member);
  }

  public Member findByNickname(String nickname) {
    return memberRepository.findByNickname(nickname);
  }

}
