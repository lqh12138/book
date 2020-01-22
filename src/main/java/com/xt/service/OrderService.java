package com.xt.service;

import com.xt.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    public Integer insertAll(Orders orders);

    public List<Orders> selectAll(@Param("page") Integer page, @Param("count") Integer count, @Param("id") Integer id);

    public Integer selectCount();

    public Integer delete(Integer id);

    public Integer updateCount(Integer bookid, Integer customerid);

    public Integer selectCountByCustomer(Integer bookid, Integer customerid);
}
