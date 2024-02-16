package com.letter.ggachi.service.member;

import com.letter.ggachi.domain.dto.request.MemberLoginRequest;
import com.letter.ggachi.domain.dto.request.MemberSignUpRequest;
import com.letter.ggachi.domain.dto.response.MemberLoginResponse;
import com.letter.ggachi.domain.dto.response.ValidateInfoResponse;
import com.letter.ggachi.domain.entity.Member;

public interface MemberService {
  void join(MemberSignUpRequest request);
  MemberLoginResponse login(MemberLoginRequest request);
  ValidateInfoResponse validateNickname(String nickname);
  ValidateInfoResponse validateEmail(String email);
}
