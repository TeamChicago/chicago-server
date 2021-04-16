package com.chicago.server.controller;

import com.chicago.server.domain.News;
import com.chicago.server.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping("news")
    public List<News> test(){
        return this.newsRepository.findAll();
    }
}
