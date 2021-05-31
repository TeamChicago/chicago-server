package com.chicago.server.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private int reliability;

    @OneToMany(mappedBy = "news")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "news")
    private List<Likes> likes = new ArrayList<>();

    @Builder
    public News(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
