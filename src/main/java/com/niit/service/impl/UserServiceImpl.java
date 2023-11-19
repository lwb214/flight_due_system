package com.niit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niit.mapper.UserMapper;
import com.niit.pojo.User;
import com.niit.service.UserService;
import com.niit.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    //添加用户
    @Override
    public int insertUser(User user) {
       int num =  userMapper.insertUser(user);
        System.out.println("添加了【" + num + "条数据");
        return num;
    }
    //查询所有用户
    @Override
    public List<User> queryAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }
    //分页查询
    @Override
    public PageInfo<User> queryPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User>  users = userMapper.selectAll();
        PageInfo<User> page = new PageInfo<>(users);
        return page;
    }
    //查询指定ID的用户
    @Override
    public List<User> queryById(Integer id) {
        List<User> user = userMapper.selectById(id);
        return user;
    }
    //查询余额
    @Override
    public Integer selectBalance(String username) {
        Integer price =  userMapper.selectBalance(username).getBalance();
        return price;
    }
    //修改指定ID的用户
    @Override
    public int updateUser(User user) {
        int num = userMapper.updateUser(user);
        return num;
    }
    //删除指定ID的用户
    @Override
    public int deleteUser(Integer id) {
        int num = userMapper.deleteUser(id);
        return num;
    }
    //验证登录
    @Override
    public R loginCheck(String username,String password) {
        List<User> users = userMapper.loginCheck(username,password);
        if (users.size() > 0)
            return R.success("登录成功！！",users);
        else
            return R.error("登录失败,用户名或密码错误！！");
    }
    //批量插入用户
    @Override
    public int batchInsert(List<User> users) {
        int num = userMapper.batchInsert(users);
        return num;
    }

}
