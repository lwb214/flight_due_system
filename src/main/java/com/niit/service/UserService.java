package com.niit.service;

import com.github.pagehelper.PageInfo;
import com.niit.pojo.User;
import com.niit.util.R;

import java.util.List;

public interface UserService {
    //添加用户
    int insertUser(User user);
    //查询所有用户
    List<User> queryAll();

    //分页查询
    PageInfo<User> queryPage(int pageNum,int pageSize);

    //根据Id查询用户
    List<User> queryById(Integer id);

    //查询余额
    Integer selectBalance(String username);

    //修改指定ID的用户
    int updateUser(User user);

    //删除指定ID的用户
    int deleteUser(Integer id);

    //验证登录
    R loginCheck(String username,String password);

    //批量插入用户
    int batchInsert(List<User> users);
}
