package com.letter.ggachi.domain.entity;


import com.letter.ggachi.domain.base.Period;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "GGACHI_LETTER")
@SequenceGenerator(name = "SEQ_GGACHI_LETTER_GENERATOR", sequenceName = "SEQ_GGACHI_LETTER")
@Getter @AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Letter extends Period {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_GGACHI_LETTER_GENERATOR")
    @Column(name = "LETTER_ID")
    private Long id;
    private String title;
    private String contents;
    private String letterStatus;
    private String phoneNumber;
    private String introduction;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member writer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

}
