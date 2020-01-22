package com.xt.service;

import com.xt.entity.Customer;

public interface CustomerService {

    public Integer login(Customer customer);

    public Integer register(Customer customer);
}
