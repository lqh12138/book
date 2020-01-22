package com.xt.service.impl;

import com.xt.entity.Orders;
import com.xt.mapper.OrderMapper;
import com.xt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer insertAll(Orders orders) {
        return orderMapper.insertAll(orders);
    }

    @Override
    public List<Orders> selectAll(Integer page, Integer count, Integer id) {
        return orderMapper.selectAll(page,count,id);
    }

    @Override
    public Integer selectCount() {
        return orderMapper.selectCount();
    }

    @Override
    public Integer delete(Integer id) {
        return orderMapper.delete(id);
    }

    @Override
    public Integer updateCount(Integer bookid, Integer customerid) {
        return orderMapper.updateCount(bookid,customerid);
    }

    @Override
    public Integer selectCountByCustomer(Integer bookid, Integer customerid) {
        return orderMapper.selectCountByCustomer(bookid,customerid);
    }

}
