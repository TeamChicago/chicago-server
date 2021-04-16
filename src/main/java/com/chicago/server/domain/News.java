package com.chicago.server.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class News {
    //test of git kraken
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long id;

    private String title;

    @Lob
    @Type(type = "text")
    private String content;

    private String writer;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime writtenTime;

    @Enumerated(EnumType.STRING)
    private NewsStatus newsStatus;

    @Builder
    public News(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
