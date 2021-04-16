package com.chicago.server.service;

import com.chicago.server.domain.News;
import com.chicago.server.repository.NewsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class NewsServiceTest {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    NewsService newsService;

    @Autowired
    EntityManager em;

    @Test
    public void 뉴스등록() throws Exception{
        //given
        News news = new News();
        news.setTitle("테슬라 주가 대폭 하락");
        news.setContent("만우절");
        news.setWriter("황세호");

        em.persist(news);

        //when
        Long saveId = newsService.enroll(news);

        //then
        News result = newsRepository.findOne(saveId);
        assertThat(news.getWriter()).isEqualTo(result.getWriter());
    }

}
