package com.briup.poll.service;

import com.briup.poll.bean.Customer;


public interface ICustomerService {
    public void addOrUpdateCustomer(Customer customer);

    public void deleteCustomer(Integer id);

    public Customer selectCustomer(Integer id);
}
