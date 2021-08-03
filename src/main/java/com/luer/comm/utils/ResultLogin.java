package com.luer.comm.utils;


import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.io.Serializable;
import java.util.LinkedHashMap;

@Api(description = "登录接口验证工具类")
@SuppressWarnings("all")
@Data
public class ResultLogin extends LinkedHashMap implements Serializable {
    // 状态码
    private int code = 406;
    // 消息
    private String msg = "内部错误";
    // 数据
    private Object data = "";
    // 时间戳
    private Long time = System.currentTimeMillis();
    //token
    private String token = " ";

    public ResultLogin() {
        this.put("msg",msg);
        this.put("code",code);
        this.put("data",data);
        this.put("time",time);
        this.put("token",token);
    }

    public ResultLogin addStair(Object k, Object v) {
        this.put(k,v);
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultLogin setCode(int code) {
        this.code = code;
        this.put("code",code);
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultLogin setMsg(String msg) {
        this.msg = msg;
        this.put("msg",msg);
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultLogin setData(Object data) {
        this.data = data;
        this.put("data",data);
        return this;
    }

    public Long getTime() {
        return time;
    }

    public ResultLogin setTime(Long time) {
        this.time = time;
        this.put("time",time);
        return this;
    }

    public String getToken() {
        return token;
    }

    public ResultLogin setToken(String token) {
        this.token = token;
        this.put("token",token);
        return this;
    }

    public static ResultLogin getSuccess(){
        return new ResultLogin().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setCode(200).setMsg("success");
    }
    public static ResultLogin getSuccess(Object data){

        return new ResultLogin().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setData(data).setCode(200).setMsg("success");
    }
    public static ResultLogin getSuccess(Object data,String token){

        return new ResultLogin().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setData(data).setCode(200).setMsg("success").setToken(token);
    }
    public static ResultLogin getFail(){

        return new ResultLogin().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setMsg("fail");
    }
    public static ResultLogin getFail(String message){

        return new ResultLogin().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setMsg(message);
    }



}