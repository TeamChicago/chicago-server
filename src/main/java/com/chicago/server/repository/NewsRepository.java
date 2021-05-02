package com.chicago.server.repository;

import com.chicago.server.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NewsRepository{

    @PersistenceContext
    private EntityManager em;

    public void save(News news){
        em.persist(news);
    }

    public News findOne(Long id){
        return em.find(News.class, id);
    }

    /*public List<News> findAll(){
        List<News> result = em.createQuery("select n from News n order by n.id desc", News.class)
                .getResultList();
        return result;
    }*/

    public List<News> findByTitle(String title){
        List<News> result = em.createQuery("select n from News n where n.title = :title order by n.id desc ", News.class)
                .setParameter("title", title)
                .getResultList();
        return result;
    }

    public void removeNews(Long id){
        News news = em.find(News.class, id);
        em.remove(news);
    }
}
