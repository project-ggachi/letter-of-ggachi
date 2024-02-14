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
    private String content;
    private String status;
    private String phoneNumber;
    private String introduction;
    private String writer;
    @JoinColumn(name = "POST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

}
