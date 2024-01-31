package com.letter.ggachi.domain.entity;
//entity -> repository -> service -> controler

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
  private String loginId;
  private String password;
  private String name;
  private String email;
  private String phoneNumber;
  private String introduction;

  @Builder

  public Member(Long id, String loginId, String password, String name, String email, String phoneNumber, String introduction) {
    this.id = id;
    this.loginId = loginId;
    this.password = password;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.introduction = introduction;
  }
}
