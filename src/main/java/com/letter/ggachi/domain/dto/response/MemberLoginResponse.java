package com.letter.ggachi.domain.dto.response;

import com.letter.ggachi.domain.entity.Member;
import com.letter.ggachi.domain.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * please explain file!
 *
 * @author :uheejoon
 * @fileName :MemberLoginResponse
 * @since :2024-02-15 오전 2:33
 */

@Getter
@Builder
public class MemberLoginResponse {
  private String nickname;
  private String password;
  private String name;
  private String email;
  private String phoneNumber;
  private String introduction;
  private List<Long> posts;

  public static MemberLoginResponse fromEntity(Member member) {
    return MemberLoginResponse.builder()
      .email(member.getEmail())
      .name(member.getName())
      .password(member.getPassword())
      .nickname(member.getNickname())
      .phoneNumber(member.getPhoneNumber())
      .introduction(member.getIntroduction())
      .posts(member.getPosts().stream().map(Post::getId).collect(Collectors.toList()))
      .build();
  }
}
