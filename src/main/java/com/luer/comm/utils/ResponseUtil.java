package com.luer.comm.utils;

import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletResponse;

@Api(description = "响应信息工具类")
public class ResponseUtil {

    public static final String LOGIN_ERROR = "{\"code\":101, \"message\":\"无权限访问,请先登录\"}";
    public static final String FORBID_MESSAGE = "{\"code\":102, \"message\":\"无权限访问,请先登录\"}";
    public static final String TOKEN_ERROR = "{\"code\":103, \"message\":\"token为空\"}";
    public static final String PRAAMETER_ERROR = "{\"code\":104, \"message\":\"参数不符\"}";
    public static final String ID_ERROR = "{\"code\":105, \"message\":\"参数为空\"}";
    public static final String PRAAMETER_NULL = "参数为null";
    public static final String DATA_NULL = "数据为null";
    public static final String RECYCLE_NULL = "回收站无数据";


    public static void response(HttpServletResponse response, String body) throws Exception {
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.getWriter().append(body);
        response.getWriter().flush();
    }

}
