package com.chicago.server.controller;

import com.chicago.server.domain.News;
import com.chicago.server.repository.NewsRepository;
import com.chicago.server.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<News> newView(@PageableDefault Pageable pageable){
        List<News> newsList = newsService.loadNews(0, 10, "writtenTime");

        System.out.println("hihi");

        return newsList;
    }
}
