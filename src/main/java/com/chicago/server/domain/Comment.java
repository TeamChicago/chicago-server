package com.chicago.server.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    private News news;

    @Column(name = "comment_content")
    private String content;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime writtenTime;

    //==연관관계 메서드==//

    public void setNews(News news){
        this.news = news;
        news.getComments().add(this);
    }
}
