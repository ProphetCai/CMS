package com.briup.poll.service.impl;

import com.briup.poll.bean.Category;
import com.briup.poll.dao.ICategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryImpl {

    @Autowired
    private ICategoryDao dao;
    public void saveOrUpdate(Category category){
        if(category.getId()!=null){
            Category cateSession = dao.findOne(category.getId());
            cateSession.setCode(category.getCode());
            cateSession.setName(category.getName());
        }
        else{
            dao.save(category);
        }
    }
    public void delete(Integer id){
        dao.exists(id);
        dao.delete(id);
    }
    public Category findOne(Integer id){
        return dao.findOne(id);
    }
    /*public void update(Category category){
        Category cateSession = dao.findOne(category.getId());
        cateSession.setCode(category.getCode());
        cateSession.setName(category.getName());
    }*/
}
