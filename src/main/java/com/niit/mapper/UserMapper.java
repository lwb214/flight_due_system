package com.niit.mapper;

import com.github.pagehelper.Page;
import com.niit.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper  {
    //添加用户
    int insertUser(User user);

    //查询所有用户
    Page<User> selectAll();

    //根据用户ID查询
    List<User> selectById(Integer id);

    //查询余额
    User selectBalance(String username);

    //修改指定ID的用户
     int updateUser(User user);

    //删除指定ID的用户
     int deleteUser(Integer id);

     //验证登录
     List<User> loginCheck(String username,String password);

    //批量插入
    int batchInsert(List<User> users);

}
