package com.letter.ggachi.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class MemberLoginRequest {
  @NotBlank(message = "이메일이 누락되었습니다.")
  private String email;
  @NotBlank(message = "비밀번호가 누락되었습니다.")
  private String password;
}
