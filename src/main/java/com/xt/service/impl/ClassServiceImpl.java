package com.xt.service.impl;

import com.xt.entity.Class;
import com.xt.mapper.ClassMapper;
import com.xt.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;


    @Override
    public List<Class> selectAll() {
        return classMapper.selectAll();
    }
}
