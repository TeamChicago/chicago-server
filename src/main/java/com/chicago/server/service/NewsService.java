package com.chicago.server.service;

import com.chicago.server.domain.News;
import com.chicago.server.repository.NewsFindRepository;
import com.chicago.server.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기 작업 수행능력 향상
@RequiredArgsConstructor // final 변수로 생성자 생성
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsFindRepository newsFindRepository;
    /**
     * 뉴스 등록
     */
    @Transactional
    public Long enroll(News news){
        newsRepository.save(news);
        return news.getId();
    }

    /**
     * 뉴스 전체 조회
     */
    public List<News> loadNews(int pageNo, int pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<News> pagedResult = newsFindRepository.findAll(paging);
        return pagedResult.getContent();
    }

    /**
     * 뉴스 단일 조회
     */
    public News loadOne(Long newsId){
        return newsRepository.findOne(newsId);
    }

    /**
     * 해당 뉴스 삭제
     */
    public void deleteOne(Long newsId){
        newsRepository.removeNews(newsId);
    }
}
