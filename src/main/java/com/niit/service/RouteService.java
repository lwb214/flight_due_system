package com.niit.service;

import com.github.pagehelper.PageInfo;
import com.niit.pojo.Route;
import com.niit.pojo.User;

import java.util.List;

public interface RouteService {
    //添加航线
    int insertRoute(Route route);

    //查询指定出发地目的地的航线
    List<Route> queryStartToEnd(String startPlace,String endPlace);
    //查询所有航线,分页展示
    PageInfo<Route> queryPage(int pageSize, int pageNum);
    //修改指定Id的航线
    int updateRoute(Route route);
    //删除指定Id的航线
    int deleteRoute(List<Integer> ids);
}
