package com.briup.poll.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class Link implements Serializable {
    private static final long serialVersionUID = 4759778516459848707L;
    @ApiModelProperty("链接id")
    private Integer id;
    @ApiModelProperty("链接名")
    private String name;
    @ApiModelProperty("链接url")
    private String url;

    public Link() {
        super();
    }

    public Link(Integer id, String name, String url) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
