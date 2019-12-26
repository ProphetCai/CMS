package com.briup.poll.service;

import com.briup.poll.bean.Link;
import com.briup.poll.exception.CustomerException;

public interface ILinkService {
    //添加或修改链接
    public void addOrUpdateLink(Link link) throws CustomerException;

    //删除
    public void deleteLink(Integer id) throws CustomerException;


    //通过id查询
    public Link selectById(Integer id) throws CustomerException;
}
