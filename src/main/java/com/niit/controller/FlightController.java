package com.niit.controller;

import com.github.pagehelper.PageInfo;
import com.niit.pojo.Flight;
import com.niit.service.FlightService;
import com.niit.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("plane")
@CrossOrigin
public class FlightController {
    private FlightService flightService;
    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }
    //查询所有航班
    @GetMapping("/queryAll")
    public Result<List<Flight>> getAll(){
        return flightService.getAll();
    }

    //分页查询航班信息
    @GetMapping("/flight/{pageNum}/{pageSize}")
    public Result<PageInfo<Flight>> getPageInfo(@PathVariable("pageNum") int pageNum,
                                                @PathVariable("pageSize") int pageSize){
        PageInfo<Flight> pageInfo = flightService.queryPageInfo(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    //根据id查询航班
    @GetMapping("/selectFlight/{id}")
    public Result<Flight> getFlightById(@PathVariable("id") int id){
        Flight flight = flightService.queryById(id);
        return Result.success(flight);
    }

    //添加航班
    @PostMapping("/addFlight")
    public Result<Flight> addFlight(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }


    //更新航班
    @PutMapping("/updateFlight")
    public Result<Flight> updateFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }
    //删除航班
    @DeleteMapping("/deleteFlight")
    public Result<Integer> deleteFlight(int planeId){
        return flightService.deleteFlight(planeId);
    }

    //批量插入航班
    @PostMapping("/batchAddFlights")
    public Result<List<Flight>> batchAddFlights(@RequestBody List<Flight> flights){
        return flightService.batchAddFlights(flights);
    }

    //批量删除航班
    @DeleteMapping("/batchDeleteFlights")
    public Result<List<Flight>> batchDeleteFlights(@RequestBody List<Flight> flightIds){
        return flightService.batchDeleteFlights(flightIds);
    }
}
