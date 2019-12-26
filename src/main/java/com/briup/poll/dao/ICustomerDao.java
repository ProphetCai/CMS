package com.briup.poll.dao;

import com.briup.poll.bean.Customer;
import org.apache.ibatis.annotations.*;

public interface ICustomerDao {

    @Insert("insert into cms_customer(username,password) values(#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void addCustomer(Customer customer);

    @Delete("delete from cms_customer where id=#{id}")
    public void deleteCustomer(Integer id);

    @Update("update cms_customer set username=#{username},password=#{password} where id=#{id}")
    public void updateCustomer(Customer customer);

    @Select("select * from cms_customer where id=#{id}")
    public Customer selectCustomer(Integer id);
}
