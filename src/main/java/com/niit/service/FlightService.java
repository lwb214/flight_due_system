package com.niit.service;

import com.github.pagehelper.PageInfo;
import com.niit.pojo.Flight;
import com.niit.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    //查询价格
    Integer selectPrice(Integer planeId);
    //查询所有航班信息
    public Result<List<Flight>> getAll();

    //根据条件查询航班
    public Flight queryById(int id);

    //分页查询
    public PageInfo<Flight> queryPageInfo(int pageNum, int pageSize);


    //添加航班信息
    public Result<Flight> addFlight(Flight flight);

    //更新航班信息
    public Result<Flight> updateFlight(Flight flight);

    //删除航班信息
    public Result<Integer> deleteFlight(int planeId);

    //批量插入
    public Result<List<Flight>> batchAddFlights(List<Flight> flightList);

    //批量删除
    public Result<List<Flight>> batchDeleteFlights(List<Flight> flightIds);
}
