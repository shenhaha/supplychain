package com.luer.springsecurity.interceptor;

import com.luer.comm.utils.MD5Util;
import com.luer.comm.utils.ResponseUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(description = "登录验证拦截器")
public class LoginInterceptor implements HandlerInterceptor {

    private static final String LOGIN_ERROR = "{\"code\":101, \"message\":\"无权限访问,请先登录\"}";
    private static final String TOKEN_ERROR = "{\"code\":103, \"message\":\"token为空\"}";
    private static final String FORBID_MESSAGE = "{\"code\":103, \"message\":\"无权限访问,请先登录\"}";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //方法调用前执行
        System.out.println("preHandle......");

        Object username = request.getSession().getAttribute("username");
        System.out.println("username: "+username);

        // 如果获取的request的session中的username参数为空（未登录），就返回登录页，否则放行访问
        if(StringUtils.isBlank("username")){
            // 未登录，给出错误信息，
            response(response, LOGIN_ERROR);
            return false;
        }
        /**token验证
         * */
       /* String token = getToken(request);
        if(StringUtils.isBlank(token)){
            response(response,TOKEN_ERROR);
            return false;
        }else if(StringUtils.isNotBlank(token)){
            String[] t = token.split("#");
            String t_id = MD5Util.convertMD5(MD5Util.convertMD5(t[0]));
            String t_username = MD5Util.convertMD5(MD5Util.convertMD5(t[1]));
            String t_password = MD5Util.convertMD5(MD5Util.convertMD5(t[2]));


            //这里
        }*/
         return true;//返回为false,拦截器拦截的方法不会调用
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //方法执行结束后执行
        System.out.println("preHandle......");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("preHandle......");
        //该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行, 这个方法的主要作用是用于清理资源的，
    }


    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            return token;
        }
        token = request.getParameter("token");
        System.out.println("---------------------->token:"+token);
        return token;
    }

    private void response(HttpServletResponse response, String body) throws Exception {
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.getWriter().append(body);
        response.getWriter().flush();
    }
}
