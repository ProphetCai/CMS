package com.briup.poll.web.controller;

import com.briup.poll.bean.Category;
import com.briup.poll.exception.CustomerException;
import com.briup.poll.service.impl.CategoryImpl;
import com.briup.poll.util.Message;
import com.briup.poll.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Api(description ="这个是栏目管理")
public class CategoryController {
    @Autowired
    private CategoryImpl impl;

    @GetMapping("/saveOrUpdate")
    @ApiOperation("添加或修改栏目")
    public Message<String> save(Category category){
        try {
            impl.saveOrUpdate(category);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }
    @GetMapping("/delete")
    @ApiOperation("删除")
    public Message<String> delete(Integer id){
        try {
            impl.delete(id);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }
    @GetMapping("/findOne")
    @ApiOperation("查找")
    public Message<Category> findOne(Integer id){
        Category category = new Category();
        try {
            category = impl.findOne(id);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success(category);
    }
    /*@GetMapping("update")
    @ApiOperation("修改")
    public Message<String> update(Category category){
        try {
            impl.update(category);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }*/
}
