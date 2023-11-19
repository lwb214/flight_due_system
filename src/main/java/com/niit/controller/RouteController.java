package com.niit.controller;

import com.github.pagehelper.PageInfo;
import com.niit.pojo.Route;
import com.niit.pojo.User;
import com.niit.service.RouteService;
import com.niit.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("route")
@CrossOrigin
public class RouteController {
    private RouteService routeService;

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }
    //添加航线
    @PostMapping("addRoute")
    public R addRoute(Route route) {
        int num = routeService.insertRoute(route);
        if (num > 0) {
            return R.success("成功【" + num + "】条数据");
        } else {
            return R.error("抱歉，添加失败了！！！");
        }
    }
    //查询指定出发地目的地的航线
    @GetMapping("getStartToEnd")
    public R getStartToEnd(String startPlace, String endPlace) {
        List<Route> routes = routeService.queryStartToEnd(startPlace, endPlace);
        return R.success("航班信息", routes);
    }
    //查询所有航线,分页展示
    @GetMapping("getPage")
    public R getAll(Integer pageNum, Integer pageSize) {
        PageInfo<Route> page = routeService.queryPage(pageNum, pageSize);
        return R.success("航线信息", page);
    }

    //删除指定Id的航线
    @DeleteMapping("outRoutes")
    public R outRoutes(@RequestBody List<Integer> ids){
        int num = routeService.deleteRoute(ids);
        if (num > 0) {
            return R.success("成功删除了【" + num + "】条数据");
        } else {
            return R.error("抱歉，数据中没有这条航线哦！");
        }
    }
    //修改指定Id的航线
    @PutMapping("setRoute")
    public R setRoute(@RequestBody Route route){
        int num = routeService.updateRoute(route);
        if (num > 0)
            return R.success("成功修改!!",route);
        else
            return R.error("抱歉，修改失败了！");
    }
}
