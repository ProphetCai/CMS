package com.briup.poll.web.controller;

import com.briup.poll.bean.Article;
import com.briup.poll.exception.CustomerException;
import com.briup.poll.service.impl.ArticleServerImpl;
import com.briup.poll.util.Message;
import com.briup.poll.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Article")
@Api(description = "这个是作品管理")
public class ArticleController {
    @Autowired
    private ArticleServerImpl service;

    @GetMapping("/saveOrUdate")
    @ApiOperation("添加或修改作品")
    public Message<String> addOrUpdateLink(Article article){
        try {
            service.saveOrUpdate(article);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }
    @GetMapping("/delete")
    @ApiOperation("删除作品")
    public Message<String> delete(Integer id){
        try {

            service.delete(id);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }
    @GetMapping("/find")
    @ApiOperation("查找作品")
    public Message<Article> findOne(Integer id){
        Article article = new Article();
        try {
            article = service.findOne(id);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success(article);
    }
   /* @GetMapping("/update")
    @ApiOperation("修改")
    public Message<String> update(Article article){
        try {
            service.update(article);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }*/
}
