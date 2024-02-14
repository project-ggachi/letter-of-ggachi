package com.letter.ggachi.domain.entity;
//entity -> repository -> service -> controler

import com.letter.ggachi.domain.base.Period;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "GGACHI_MEMBER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "SEQ_GGACHI_MEMBER_GENERATOR", sequenceName = "SEQ_SEQ_GGACHI_MEMBER")
public class Member extends Period {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_GGACHI_MEMBER_GENERATOR")
  @Column(name = "MEMBER_ID")
  private Long id;
  private String nickName;
  private String password;
  private String name;
  private String email;
  private String phoneNumber;
  private String introduction;
  @OneToMany(mappedBy = "member")
  private List<Post> posts;

}
