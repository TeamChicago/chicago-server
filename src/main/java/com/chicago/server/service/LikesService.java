package com.chicago.server.service;

import com.chicago.server.domain.Likes;
import com.chicago.server.domain.News;
import com.chicago.server.repository.CommentRepository;
import com.chicago.server.repository.LikesRepository;
import com.chicago.server.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LikesService {
    private final EntityManager em;
    private final NewsRepository newsRepository;
    private final LikesRepository likesRepository;
    private final CommentRepository commentRepository;

    /**
     * 좋아요 추가 및 현재 좋아요 수 반환
     */
    @Transactional
    public int likes(Long newsId){

        // 엔티티 조회
        News news = newsRepository.findOne(newsId);

        // 좋아요
        Likes likes = Likes.createLike(news);

        likesRepository.save(likes);
        int news_len = likesRepository.lenByNews(newsId);
        return news_len;
    }

    /**
     * 좋아요 취소 및 현재 좋아요 수 반환
     */
    public int cancelLike(Long newsId){
        return 0;
    }

    /**
     * 좋아요 수
     */
    public int countLiked(Long newsId){
        return likesRepository.lenByNews(newsId);
    }
}
