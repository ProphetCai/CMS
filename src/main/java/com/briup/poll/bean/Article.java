package com.briup.poll.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "cms_article")
@ApiModel
public class Article implements Serializable {
    private static final long serialVersionUID = 7737537637749861950L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "信息id")
    private Integer id;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "点击量",hidden = true)
    private int clickTimes;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "发布时间",hidden = true)
    private Date publishDate;
    @ApiModelProperty(value = "标题")
    private String title;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Article() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {

        return publishDate;
    }

    public void setPublishDate(Date publishDate) {

        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
