package com.niit.controller;

import com.niit.service.FlightService;
import com.niit.service.IndentService;
import com.niit.service.UserService;
import com.niit.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("indent")
@CrossOrigin
public class IndentController {
    private IndentService indentService;
    private UserService userService;
    private FlightService flightService;
    @Autowired
    public void setIndentService(IndentService indentService) {
        this.indentService = indentService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    //预定机票
    @GetMapping("queryPrice")
    public R queryPrice(String username){
        Integer balance = userService.selectBalance(username);
//        Integer price = flightService.selectPrice();
        return R.error("");
    }
}
