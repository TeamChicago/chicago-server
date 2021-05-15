package com.chicago.server.repository;

import com.chicago.server.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final EntityManager em;

    public void save(Comment comment){ em.persist(comment); }

    public List<Comment> findAll(){
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }

    public List<Comment> findByNews(Long newsId){
        return em.createQuery("select c from Comment c join c.news n " +
                "where n.id = :newsId")
                .setParameter("newsId", newsId)
                .getResultList();
    }

    public Long remove(Long id){
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
        return id;
    }
}
