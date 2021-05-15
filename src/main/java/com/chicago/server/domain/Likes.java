package com.chicago.server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Likes {

    @Id @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    private News news;

    //== 연관관계 메서드 ==//
    public void setNews(News news){
        this.news = news;
        news.getLikes().add(this);
    }

    //== 생성 메서드 ==//
    public static Likes createLike(News news){
        Likes likes = new Likes();
        likes.setNews(news);
        return likes;
    }

}
