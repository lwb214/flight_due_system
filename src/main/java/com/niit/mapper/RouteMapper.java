package com.niit.mapper;

import com.github.pagehelper.Page;
import com.niit.pojo.Route;
import com.niit.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteMapper {
    //添加航线
    int insertRoute(Route route);

    //查询指定出发地目的地的航线
    List<Route> selectStartToEnd(String startPlace,String endPlace);
    //查询所有航线,分页展示
    Page<Route> selectAll();
    //修改指定Id的航线
    int updateRoute(Route route);
    //删除指定Id的航线
    int deleteRoute(List<Integer> ids);
}
