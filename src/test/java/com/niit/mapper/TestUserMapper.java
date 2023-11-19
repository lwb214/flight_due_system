package com.niit.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niit.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class TestUserMapper {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void test01(){
        User user = new User();
        user.setUserid(003);
        user.setUsername("张翠山");
        user.setPassword("123");
        user.setIdCard("642233198812305566");
        user.setPhoneNumber("15245124566");
        user.setSex(0);
        user.setBalance(700);
        int num =  userMapper.insertUser(user);
        log.info("添加成功了【"+ num + "】消息");
    }
    @Test
    public void test02(){
        PageHelper.startPage(1,3);
        List<User> users = userMapper.selectAll();
        PageInfo<User> page = new PageInfo<>(users);
       log.info("用户信息" + page);
    }
}
