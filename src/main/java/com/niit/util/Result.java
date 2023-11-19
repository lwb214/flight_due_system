package com.niit.util;

import lombok.Data;

/**
 * @ProjectName: springboot3_music
 * @Package: com.niit.util
 * @ClassName: Result
 * @Author: zjh
 * @description: 封装分会数据
 * @date: 2023/9/18 9:51
 * @version: 1.0
 */
@Data
public class Result<T> {

    private String code;
    private String msg;
    private T data;

    public Result() {
    }
    public Result(T data) {
        this.data = data;
    }
    public static Result success(){
        Result result=new Result();
        result.setCode("200");
        result.setMsg("成功");
        return result;
    }
    public static <T>Result<T> success(T data){
        Result<T> result=new Result(data);
        result.setCode("200");
        result.setMsg("成功~~~");
        return result;
    }
    public static <T>Result<T> success(String code,String msg,T data){
        Result<T> result=new Result(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result error(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}