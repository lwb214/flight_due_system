package com.niit.mapper;

import com.niit.pojo.Indent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IndentMapper {
    //插入订单
    int insertIndent(Indent indent);
}
