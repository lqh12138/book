package com.xt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xt.entity.Book;
import com.xt.mapper.BookMapper;
import com.xt.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> selectAll(Integer page, Integer count, Integer typeId) {
        return bookMapper.selectAll(page, count, typeId);
    }

    @Override
    public Integer selectCount(Integer typeId) {
        return bookMapper.selectCount(typeId);
    }
}
