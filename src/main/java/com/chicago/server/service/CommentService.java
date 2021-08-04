package com.chicago.server.service;

import com.chicago.server.domain.Comment;
import com.chicago.server.domain.News;
import com.chicago.server.repository.CommentRepository;
import com.chicago.server.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final EntityManager em;
    private final NewsRepository newsRepository;
    private final CommentRepository commentRepository;

    /**
     * 댓글 작성
     */
    @Transactional
    public Long writeComment(Comment comment){
        commentRepository.save(comment);
        return comment.getId();
    }

    /**
     * 댓글 삭제
     */
    public Long deleteComment(Long id){
        return commentRepository.remove(id);
    }

    /**
     * 댓글 전체 조회
     */
    public List<Comment> viewComments(Long newId){
        return commentRepository.findByNews(newId);
    }
}
