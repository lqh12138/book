package com.xt.mapper;

import com.xt.entity.Class;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ClassMapper {

    //查询所有书的分类
    public List<Class> selectAll();

}
