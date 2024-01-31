package com.letter.ggachi.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class MemberLoginDto {
  @NotBlank(message = "아이디를 입력해주세요")
  private String loginId;

  @NotBlank(message = "비밀번호를 입력해주세요")
  private String password;
}
