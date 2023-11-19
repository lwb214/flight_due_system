package com.niit.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestFlightService {
    private FlightService flightService;
    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }
    @Test
    public void Test01(){
        Integer planeId  = 2;
        Integer price = flightService.selectPrice(planeId);
        log.info("该航班的价格为" + price);
    }
}
