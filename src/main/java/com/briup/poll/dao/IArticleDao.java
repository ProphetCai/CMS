package com.briup.poll.dao;

import com.briup.poll.bean.Article;
import org.springframework.data.repository.CrudRepository;

public interface IArticleDao extends CrudRepository<Article,Integer> {
}
