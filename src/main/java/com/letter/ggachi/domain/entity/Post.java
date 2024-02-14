package com.letter.ggachi.domain.entity;

import com.letter.ggachi.domain.base.Period;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "GGACHI_POST")
@SequenceGenerator(name = "SEQ_GGACHI_POST_GENERATOR", sequenceName = "SEQ_GGACHI_POST")
@ToString @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_GGACHI_POST_GENERATOR")
    @Column(name = "POST_ID")
    private Long id;
    private String title;
    private String status;
    private String enc;
    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public Post(Long id, String title, String status, String enc, Member member) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.enc = enc;
        this.member = member;
    }
}
