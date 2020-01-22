package com.xt.mapper;

import com.xt.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

    public Integer login(Customer customer);

    public Integer register(Customer customer);

}
