package com.letter.ggachi.service.member.impl;

import com.letter.ggachi.domain.entity.Member;
import com.letter.ggachi.repository.member.MemberRepository;
import com.letter.ggachi.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository;

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }
}
