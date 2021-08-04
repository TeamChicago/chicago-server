package com.chicago.server.repository;

import com.chicago.server.domain.Likes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikesRepository {

    private final EntityManager em;

    public void save(Likes likes){ em.persist(likes); }

    public Likes findOne(Long id){ return em.find(Likes.class, id); }

    public int lenByNews(Long id){
        List resultList = em.createQuery("select l from Likes l join l.news n " +
                "where n.id = :newId")
                .setParameter("newId", id)
                .getResultList();

        return resultList.size();
    }
}
