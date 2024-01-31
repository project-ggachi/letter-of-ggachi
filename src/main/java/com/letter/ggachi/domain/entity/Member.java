package com.letter.ggachi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GGACHI_MEMBER")
@ToString @Getter @Setter
@NoArgsConstructor
public class Member {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MEMBER_ID")
  private Long id;


  private String nickname;
  private String password;
  private String name;
  private String phoneNumber;

  @Builder
  public Member(Long id, String nickname, String password, String name, String phoneNumber) {
    this.id = id;
    this.nickname = nickname;
    this.password = password;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

}
