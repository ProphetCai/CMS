package com.briup.poll.service.impl;

import com.briup.poll.bean.Customer;
import com.briup.poll.dao.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private ICustomerDao dao;
    //进行加密，需要提供配置类，配置该对象,默认该对象没有创建
    @Autowired
    private PasswordEncoder passwordEncoder;

    //登录的时候会传入用户名
    @Override
    public UserDetails loadUserByUsername(String username){
        Customer customer = dao.findCustomerByName(username);
        if(customer==null){
            throw new UsernameNotFoundException(username+"不存在");
        }
        //成功返回User对象，User是UserDetails的实现类
        //密码需要进行加密
        //第三个参数：是权限，每个人都是admin权限
        return new User(customer.getUsername(),
                passwordEncoder.encode(customer.getPassword()),
                AuthorityUtils.createAuthorityList("admin"));
    }
}
