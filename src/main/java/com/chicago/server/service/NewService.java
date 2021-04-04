package com.chicago.server.service;

import com.chicago.server.domain.News;
import com.chicago.server.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기 작업 수행능력 향상
@RequiredArgsConstructor // final 변수로 생성자 생성
public class NewService {

    private final NewsRepository newsRepository;

    /**
     * 뉴스 등록
     */
    @Transactional
    public Long join(News news){
        newsRepository.save(news);
        return news.getId();
    }

    /**
     * 뉴스 전체 조회
     */
    public List<News> loadNews(){
        return newsRepository.findAll();
    }

    /**
     * 뉴스 단일 조회
     */
    public News loadOne(Long newsId){
        return newsRepository.findOne(newsId);
    }

}
