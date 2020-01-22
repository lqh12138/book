package com.xt.service.impl;

import com.xt.entity.Customer;
import com.xt.mapper.CustomerMapper;
import com.xt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer login(Customer customer) {
        return customerMapper.login(customer);
    }

    @Override
    public Integer register(Customer customer) {
        return customerMapper.register(customer);
    }
}
