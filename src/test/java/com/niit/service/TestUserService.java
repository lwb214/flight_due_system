package com.niit.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestUserService {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Test
    public void Test01(){
        String username = "周芷若";
        Integer balance = userService.selectBalance(username);
        log.info("该用户的余额为"+ balance);
    }
}
