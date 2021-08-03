package com.luer.operator.controller;

import com.luer.comm.utils.MD5Util;
import com.luer.comm.utils.PageBean;
import com.luer.comm.utils.ResultLogin;
import com.luer.comm.utils.ResultSet;
import com.luer.operator.bean.Operator;
import com.luer.operator.service.OperatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(description = "操作员接口")
@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @CrossOrigin
    @ApiOperation(value="用户登录验证", notes="用户登录验证", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "String ")
    })
    @PostMapping("/login")
    public ResultLogin login(@RequestBody Operator operator, HttpSession session){
        Operator operator1= operatorService.selectOperatorByUsername(operator.getUsername());
        if(null == operator1){
            return ResultLogin.getFail("用户名不存在");
        }
        String  sqlPassword = operator1.getPassword();
        if(!(sqlPassword).equals(operator.getPassword())){
            return ResultLogin.getFail("密码不正确");
        }
            if(operator1.getUsername() != null){
            session.setAttribute("username",operator.getUsername());
        }
        /**
         * 用MD5给用户名密码加密
         * */
        String md5Id = MD5Util.string2MD5(operator1.getId());
        String md5Username = MD5Util.string2MD5(operator1.getUsername());
        String md5Password = MD5Util.string2MD5(operator1.getPassword());
        String pingjie = md5Id+"#"+md5Username+"#"+md5Password;
        return ResultLogin.getSuccess(operator1,pingjie);
    }

    @CrossOrigin
    @ApiOperation(value = "根据id查询用户信息", notes = "根据id查询用户信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户信息id", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/selectOperatorById")
    public ResultSet selectOperatorById(String id){
        Operator operator = operatorService.selectOperatorById(id);
        return ResultSet.getSuccess(operator);
    }

    @CrossOrigin
    @ApiOperation(value = "根据id删除用户信息", notes = "根据id删除用户信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户信息id", required = true, dataType = "String")
    @GetMapping("/deleteById")
    public ResultSet deleteById(String id){
        operatorService.deleteById(id);
        return ResultSet.getSuccess();
    }

    @CrossOrigin
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息", httpMethod = "POST")
    @ApiImplicitParam(name = "operator", value = "Operator对象", required = true, dataType = "Goodsmessage")
    @ResponseBody
    @PostMapping("/saveOperator")
    public ResultSet saveOperator(@RequestBody Operator operator){
        operatorService.insert(operator);
        return ResultSet.getSuccess();
    }

    @CrossOrigin
    @ApiOperation(value = "根据用户名查询operator", notes = "根据用户名查询operator", httpMethod = "GET")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/seclectOperatorByUsername")
    public ResultSet seclectOperatorByUsername(String username){
        Operator operator = operatorService.selectOperatorByUsername(username);
        return ResultSet.getSuccess(operator);
    }


    @CrossOrigin
    @ApiOperation(value = "查询所有操作员信息", notes = "查询所有操作员信息", httpMethod = "GET")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/seclet")
    public ResultSet select(){
        List<Operator> operator = operatorService.select();
        return ResultSet.getSuccess(operator);
    }



    @CrossOrigin
    @ApiOperation(value="用户信息分页查询", notes="用户信息分页查询", httpMethod = "POST")
    @ApiImplicitParam(name = "pageBean", value = "分页查询实体类", required = true, dataType = "PageBean")
    @ResponseBody
    @PostMapping("/queryPage")
    public PageBean queryPage(@RequestBody PageBean pageBean){
        int pageNum = pageBean.getPageNum();
        int pageSize = pageBean.getPageSize();
        if(pageNum > 0 && pageSize > 0) {
            int totalRecord = operatorService.count();
            pageBean = new PageBean(pageNum, pageSize, totalRecord);

            //从该行开始拿数据
            int startIndex = (pageNum - 1) * pageSize;
            pageBean.setStartIndex(startIndex);

            //数据集合
            List<Operator> operators = operatorService.findListDataPage(startIndex, pageSize);
            pageBean.setList(operators);
            pageBean.setMsg("success");
        }else{
            pageBean.setMsg("error");
        }
        return pageBean;
    }

}
