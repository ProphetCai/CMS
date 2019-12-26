package com.briup.poll.web.controller;

import com.briup.poll.bean.Customer;
import com.briup.poll.exception.CustomerException;
import com.briup.poll.service.ICustomerService;
import com.briup.poll.util.Message;
import com.briup.poll.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Customer")
@Api(description = "这是用户管理")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/addOrUpdate")
    @ApiOperation("添加或修改")
    public Message<String> addOrUpdateCustomer(Customer customer){
        try {
            service.addOrUpdateCustomer(customer);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }

    @GetMapping("/delete")
    @ApiOperation("删除")
    public Message<String> deleteCustomer(Integer id){
        try {
            service.deleteCustomer(id);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success("success");
    }

    @GetMapping("/select")
    @ApiOperation("查询")
    public Message<Customer> selectCustomer(Integer id){
        Customer customer = new Customer();
        try {
            customer = service.selectCustomer(id);
        }catch (CustomerException e){
            return MessageUtil.error(500,e.getMessage());
        }
        return MessageUtil.success(customer);
    }
}
