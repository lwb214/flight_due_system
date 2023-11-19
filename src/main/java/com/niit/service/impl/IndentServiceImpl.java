package com.niit.service.impl;

import com.niit.mapper.IndentMapper;
import com.niit.pojo.Indent;
import com.niit.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndentServiceImpl implements IndentService {

    private IndentMapper indentMapper;
    @Autowired
    public void setIndentMapper(IndentMapper indentMapper) {
        this.indentMapper = indentMapper;
    }

    @Override
    public int insertIndent(Indent indent) {
        int num = indentMapper.insertIndent(indent);
        return num;
    }
}
