package com.chicago.server.repository;

import com.chicago.server.domain.News;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsFindRepository extends PagingAndSortingRepository<News, Long> {

}
