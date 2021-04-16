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
        news.setContent("The shooting led hundreds of people to gather in front of the Brooklyn Center Police Department headquarters on Sunday night. Police fired tear gas, projectiles, and flash-bang grenades at protesters, as captured by pictures and videos tweeted from the scene. Later, at around 11:30 p.m., police declared the protests \"unlawful\" and threatened to arrest anyone who remained, Minnesota Public Radio News reported. Minnesota Department of Public Safety Commissioner John Harrington claimed on Monday morning that about 20 businesses were looted.45.3\n" +
                "Tesla\n" +
                "Earlier in the day, hundreds had congregated at the scene of Wright’s death. Police officers arrived in riot gear, according to Minneapolis Star Tribune reporter Kim Hyatt. Some protesters smashed police car windshields, and a police officer shot a man with a rubber bullet, Hyatt tweeted.70.2");
        news.setWriter("황세호");

        //when
        Long saveId = newsService.enroll(news);

        //then
        News result = newsRepository.findOne(saveId);
        assertThat(news.getWriter()).isEqualTo(result.getWriter());
    }

}
