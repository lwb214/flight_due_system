package com.niit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niit.mapper.FlightMapper;
import com.niit.pojo.Flight;
import com.niit.service.FlightService;
import com.niit.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightMapper flightMapper;
    @Autowired
    public void setFlightMapper(FlightMapper flightMapper) {
        this.flightMapper = flightMapper;
    }
    //查询价格
    @Override
    public Integer selectPrice(Integer planeId) {
        Integer price = flightMapper.selectPrice(planeId).getPrice();
        return price;
    }
    //查看所有航班
    @Override
    public Result<List<Flight>> getAll(){
        List<Flight> flights = flightMapper.selectAll();
        return Result.success("200","查询所有航班成功",flights);
    }

    //根据id查询航班
    @Override
    public Flight queryById(int id) {
        return flightMapper.selectFlightById(id);
    }

    //分页查询
    @Override
    public PageInfo<Flight> queryPageInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Flight> list = flightMapper.selectAll();
        PageInfo<Flight> pageInfo =new PageInfo<>(list);
        return pageInfo;
    }
    //添加航班
    @Override
    public Result<Flight> addFlight(Flight flight) {
        int num = flightMapper.insertFlight(flight);
        if(num>0){
            return  Result.success("202","新增航班成功~~",flight);
        }else {
            return Result.error("200","新增航班失败，请联系管理员~~");
        }
    }
    //更新航班
    @Override
    public Result<Flight> updateFlight(Flight flight) {
        int num = flightMapper.updateFlight(flight);
        if(num == 1){
            return  Result.success("202","修改航班成功~~",flight);
        }else{
            return Result.error("200","修改航班失败，请联系管理员~~");
        }
    }
    //删除航班
    @Override
    public Result<Integer> deleteFlight(int planeId) {
        int num = flightMapper.deleteFlight(planeId);
        if(num == 1){
            return Result.success("202","删除航班成功",planeId);
        }else {
            return Result.error("200","删除航班失败，请联系管理员");
        }
    }

    //批量插入航班
    public Result<List<Flight>> batchAddFlights(List<Flight> flightList) {
        int num = flightMapper.batchInsertFlight(flightList);
        if(num>0){
            return Result.success("202","批量插入航班成功",flightList);
        }else {
            return Result.error("200", "批量插入航班失败，请联系管理员~~");
        }
    }

    //批量删除航班
    public Result<List<Flight>> batchDeleteFlights(List<Flight> flightIds) {
        int num = flightMapper.batchDeleteFlight(flightIds);
        if(num>0){
            return Result.success("202", "批量删除航班成功~~",flightIds);
        }else {
            return Result.error("200", "批量删除航班失败，请联系管理员~~");
        }
    }
}
