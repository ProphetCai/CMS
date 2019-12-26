package com.briup.poll.dao;

import com.briup.poll.bean.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category,Integer> {

}
