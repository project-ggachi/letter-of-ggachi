package com.letter.ggachi.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "GGACHI_LETTER")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Letter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LETTER_ID")
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private String phoneNumber;
    private String introduction;
    private String writer;

    //@Builder

    public Letter(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, String status, String phoneNumber, String introduction) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.introduction = introduction;
    }
}
