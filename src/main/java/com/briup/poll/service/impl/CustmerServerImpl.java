package com.briup.poll.service.impl;

import com.briup.poll.bean.Customer;
import com.briup.poll.dao.ICustomerDao;
import com.briup.poll.exception.CustomerException;
import com.briup.poll.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustmerServerImpl implements ICustomerService{

    @Autowired
    private ICustomerDao dao;

    @Override
    public void addOrUpdateCustomer(Customer customer) {
        if(customer==null){
            throw new CustomerException("不能添加或修改空Customer");
        }
        if(customer.getId()==null){
            dao.addCustomer(customer);
        }
        else {
            dao.updateCustomer(customer);
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        if(dao.selectCustomer(id)==null){
            throw new CustomerException("不存在");
        }
        else {
            dao.deleteCustomer(id);
        }
    }

    @Override
    public Customer selectCustomer(Integer id) {
        return dao.selectCustomer(id);
    }
}
