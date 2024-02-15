package com.letter.ggachi.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * please explain file!
 *
 * @author :uheejoon
 * @fileName :MemberSignUpRequest
 * @since :2024-02-14 오후 9:45
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignUpRequest {
  @NotBlank(message = "닉네임이 누락되었습니다.")
  private String nickname;

  @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?!.*\\s).+$"
    , message = "비밀번호는 영어와 숫자를 혼용해야 하며 공백은 사용할 수 없습니다.")
  @Size(min = 8, max = 16, message = "비밀번호는 최소 8글자 이상 최대 16글자 이하로 작성해야 합니다.")
  private String password;

  @NotBlank(message = "이름이 누락되었습니다.")
  private String name;

  @NotBlank(message = "이메일이 누락되었습니다.")
  private String email;

  @NotBlank(message = "전화번호가 누락되었습니다.")
  private String phoneNumber;
  
  private String introduction;
}
