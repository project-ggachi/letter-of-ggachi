package com.letter.ggachi.domain.entity;

import com.letter.ggachi.domain.base.Period;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "GGACHI_POST")
@SequenceGenerator(name = "SEQ_GGACHI_POST_GENERATOR", sequenceName = "SEQ_GGACHI_POST")
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_GGACHI_POST_GENERATOR")
    @Column(name = "POST_ID")
    private Long id;
    private String title;
    private String postStatus;
    private String postEnc;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Letter> letters;

}
