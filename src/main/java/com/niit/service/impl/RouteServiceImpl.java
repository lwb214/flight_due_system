package com.niit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niit.mapper.RouteMapper;
import com.niit.mapper.UserMapper;
import com.niit.pojo.Route;
import com.niit.pojo.User;
import com.niit.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private RouteMapper routeMapper;
    @Autowired
    public void setRouteMapper(RouteMapper routeMapper) {
        this.routeMapper = routeMapper;
    }

    //添加航线
    @Override
    public int insertRoute(Route route) {
        int num = routeMapper.insertRoute(route);
        return num;
    }
    //查询指定出发地目的地的航线
    @Override
    public List<Route> queryStartToEnd(String startPlace, String endPlace) {
        List<Route> routes = routeMapper.selectStartToEnd(startPlace,endPlace);
        return routes;
    }
    //查询所有航线,分页展示
    @Override
    public PageInfo<Route> queryPage( int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Route> routes = routeMapper.selectAll();
        PageInfo<Route> page = new PageInfo<>(routes);
        return page;
    }
    //修改指定Id的航线
    @Override
    public int updateRoute(Route route) {
        int num = routeMapper.updateRoute(route);
        return num;
    }
    //删除指定Id的航线
    @Override
    public int deleteRoute(List<Integer> ids) {
        int num = routeMapper.deleteRoute(ids);
        return num;
    }
}
