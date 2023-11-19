package com.niit.mapper;

import com.niit.pojo.Flight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlightMapper {
    //查询价格
    Flight selectPrice(Integer planeId);
    //查询所有航班信息
    public List<Flight> selectAll();

    //根据条件查询
    public Flight selectFlightById(int id);

    //添加航班信息
    public int insertFlight(Flight flight);

    //更新航班信息
    public int updateFlight(Flight flight);

    //删除航班信息
    public int deleteFlight(int planeId);

    // 批量插入航班信息
    public int batchInsertFlight(List<Flight> flightList);

    // 批量删除航班信息
    public int batchDeleteFlight(List<Flight> flightIds);
}
