package com.briup.poll.service.impl;

import com.briup.poll.bean.Link;
import com.briup.poll.dao.ILinkDao;
import com.briup.poll.exception.CustomerException;
import com.briup.poll.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LinkServerImpl implements ILinkService {

    @Autowired
    private ILinkDao dao;
    @Override
    public void addOrUpdateLink(Link link) throws CustomerException {
        if(link==null){
            throw new CustomerException("不能添加空链接");
        }
        if(link.getId()!=null){
            dao.updateById(link);
        }
        else {
            dao.addLink(link);
        }
    }
    public void deleteLink(Integer id) throws CustomerException{
        if(dao.selectById(id)==null){
            throw new CustomerException("id不存在");
        }
        dao.deleteLink(id);
    }

    public Link selectById(Integer id) throws CustomerException{
        if(dao.selectById(id)==null){
            throw new CustomerException("id不存在");
        }
        return dao.selectById(id);
    }
}
