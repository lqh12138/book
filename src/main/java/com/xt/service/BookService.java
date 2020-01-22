package com.xt.service;

import com.xt.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    //分页查询所有
    public List<Book> selectAll(@Param("page") Integer page, @Param("count") Integer count, @Param("typeId") Integer typeId);

    //查询所有记录数
    public Integer selectCount(@Param("typeId") Integer typeId);
}
