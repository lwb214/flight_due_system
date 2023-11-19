package com.niit.controller;

import com.github.pagehelper.PageInfo;
import com.niit.pojo.User;
import com.niit.service.UserService;
import com.niit.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    //添加用户
    @PostMapping("addUser")
    public R addUser(@RequestBody User user){
        int num = userService.insertUser(user);
        if(num > 0 ){
            return R.success("添加成功了【" + num + "】条数据",user);
        }else {
            return R.error("抱歉，添加失败了，请检查数据");
        }
    }
    //批量添加用户
    @PostMapping("batchInsert")
    public R batchAdd(@RequestBody List<User> users){
        int num = userService.batchInsert(users);
        if(num > 0 ){
            return R.success("添加成功了【" + num + "】条数据");
        }else {
            return R.error("添加失败,请检查数据");
        }
    }
    //查询所有用户,分页显示
    @GetMapping("page")
    public R getPage(Integer pageNum,Integer pageSize){
        PageInfo<User> users = userService.queryPage(pageNum,pageSize);
        return R.success("用户信息",users);
    }
    //查询指定Id的用户
    @GetMapping("queryById")
    public R getById(Integer userid){
        List<User> users  = userService.queryById(userid);
        if(users.size() > 0){
            return R.success("id为【" + userid +"】的用户信息",users);
        }else {
            return R.error("抱歉,数据中没有这个用户哦！！");
        }
    }
    //修改指定Id的用户
    @PutMapping("setUser")
    public R setUser(@RequestBody User user){
        int num = userService.updateUser(user);
        if(num > 0){
            return R.success("成功修改了Id为【"+ user.getUserid() + "】的用户",user);
        }else{
            return R.error("抱歉，修改失败了！");
        }
    }
    //删除指定Id的用户
    @DeleteMapping("outUser")
    public R outUser(Integer userid){
        int num = userService.deleteUser(userid);
        if(num > 0){
            return R.success("成功删除Id为【" + userid+"】的用户！！");
        }else{
            return R.error("抱歉，删除失败了！");
        }
    }
    //登录验证
    @GetMapping("login")
    public R loginCheck(@RequestBody String username,String password){
        R r = userService.loginCheck(username,password);
        return r;
    }
}