package com.briup.poll.service.impl;

import com.briup.poll.bean.Article;
import com.briup.poll.dao.IArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ArticleServerImpl {

    @Autowired
    private IArticleDao dao;
    public void saveOrUpdate(Article article){
        if(article.getId()!=null){
            Article sessionArticle = (Article) dao.findOne(article.getId());
            sessionArticle.setAuthor(article.getAuthor());
            sessionArticle.setCategory_id(article.getCategory_id());
            sessionArticle.setClickTimes(article.getClickTimes());
            sessionArticle.setContent(article.getContent());
            sessionArticle.setId(article.getId());
            sessionArticle.setTitle(article.getTitle());
        }
        else{
            article.setPublishDate(new Date());
            dao.save(article);
        }
    }
    public void delete(Integer id){
        dao.exists(id);
        dao.delete(id);
    }
    /*public void update(Article article){
         Article sessionArticle = (Article) dao.findOne(article.getId());
        sessionArticle.setAuthor(article.getAuthor());
        sessionArticle.setCategory_id(article.getCategory_id());
        sessionArticle.setClickTimes(article.getClickTimes());
        sessionArticle.setContent(article.getContent());
        sessionArticle.setId(article.getId());
        sessionArticle.setTitle(article.getTitle());
    }*/


    public Article findOne(Integer id) {
        return dao.findOne(id);
    }
}
