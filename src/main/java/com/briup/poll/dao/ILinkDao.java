package com.briup.poll.dao;

import com.briup.poll.bean.Link;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

//操作cms_link
@Component("com.briup.poll.dao")
public interface ILinkDao {
    //添加链接
    @Insert("insert into cms_link(name,url) values(#{name},#{url})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void addLink(Link link);

    //删除
    @Delete("delete from cms_link where id=#{id}")
    public void deleteLink(Integer id);

    //更新
    @Update("update cms_link set name=#{name},url=#{url} where id=#{id}")
    public void updateById(Link link);

    //查询
    @Select("select * from cms_link where id=#{id}")
    public Link selectById(Integer id);
}
