package com.chicago.server.controller;

import com.chicago.server.domain.News;
import com.chicago.server.repository.NewsRepository;
import com.chicago.server.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
@Slf4j
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsService newsService;

    @RequestMapping("news")
    public List<News> newsView(@PageableDefault Pageable pageable){
        List<News> newsList = newsService.loadNews(0, 10, "writtenTime");

        System.out.println("hihi");

        return newsList;
    }

    @PostMapping("news")
    public String newPost(@RequestBody NewsPostForm newsPostForm){
        News news = new News();
        news.setWriter(newsPostForm.getWriter());
        news.setContent(newsPostForm.getContent());
        news.setTitle(newsPostForm.getTitle());
        newsService.enroll(news);
        return "success to insert";
    }
}
