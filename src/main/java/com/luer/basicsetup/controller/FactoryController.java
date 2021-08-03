package com.luer.basicsetup.controller;


import com.luer.basicsetup.bean.ExampleVo;
import com.luer.basicsetup.bean.Factorymanage;
import com.luer.basicsetup.service.FactoryService;
import com.luer.comm.utils.PageBean;
import com.luer.comm.utils.PageResult;
import com.luer.comm.utils.ResponseUtil;
import com.luer.comm.utils.ResultSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/factory")
@Api(description = "工厂管理接口")
public class FactoryController {

    @Autowired
    FactoryService factoryService;

    @CrossOrigin
    @ApiOperation(value = "添加工厂信息", notes = "添加工厂信息", httpMethod = "POST")
    @ApiImplicitParam(name = "factorymanage", value = "Factorymanage对象", required = true, dataType = "Factorymanage")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet save(@RequestBody Factorymanage factorymanage) {
        /**工厂编码唯一*/
        String code = factorymanage.getCode();
        Factorymanage factorymanage1 = factoryService.selectByCode(code);
        if(factorymanage1 == null){
            factoryService.insert(factorymanage);
            return ResultSet.getSuccess(factorymanage);
        }
        return ResultSet.getFail("编码以存在!");

    }

    @CrossOrigin
    @ApiOperation(value="根据ids批量删除工厂信息", notes="根据ids批量删除工厂信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo(ids)", value = "工厂信息id数组对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/delete")
    public ResultSet delete(@RequestBody ExampleVo vo){
        List<String> list = vo.getIds();
        if(list.isEmpty()){
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        factoryService.deleteByIds(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "修改工厂信息", notes = "修改工厂信息 传入一个Factorymanage对象", httpMethod = "POST")
    @ApiImplicitParam(name = "factorymanage", value = "Factorymanage对象", required = true, dataType = "Factorymanage")
    @ResponseBody
    @PostMapping(value="/update")
    public ResultSet  update(@RequestBody Factorymanage factorymanage){
        factoryService.updateById(factorymanage.getId(),factorymanage);
        Factorymanage factorymanage1 = factoryService.selectById(factorymanage.getId());
        return ResultSet.getSuccess(factorymanage1);
    }

    @CrossOrigin
    @ApiOperation(value = "查询全部信息", notes = "查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/select")
    public ResultSet select(){
        List<Factorymanage> factorymanages = factoryService.select();
        /**对list集合进行判空*/
        if(factorymanages.isEmpty() ){
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(factorymanages);
    }


    @CrossOrigin
    @ApiOperation(value = "根据code查询详细地址信息", notes = "用于采购单根据code调取详细地址信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectAddressByCode")
    public String selectAddressByCode(String code,HttpServletResponse response) throws Exception{
        String address = factoryService.selectAddressByCode(code);
        /**对list集合进行判空*/
        if(StringUtils.isBlank(address)){
            //为空
            ResponseUtil.response(response, ResponseUtil.DATA_NULL);
        }
        return address;
    }


    @CrossOrigin
    @ApiOperation(value = "根据code查询详细地址信息", notes = "用于采购单根据code调取详细地址信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectDAddressByCode")
    public String selectDAddressByCode(String code,HttpServletResponse response) throws Exception{
        String address = factoryService.selectDAddressByCode(code);
        /**对list集合进行判空*/
        if(StringUtils.isBlank(address)){
            //为空
            ResponseUtil.response(response, ResponseUtil.DATA_NULL);
        }
        return address;
    }



    @CrossOrigin
    @ApiOperation(value="工厂信息页分查询", notes="工厂信息页分查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", dataType = "String"),
            @ApiImplicitParam(name = "company", value = "所属公司", dataType = "String"),
            @ApiImplicitParam(name = "spare01", value = "其他查询", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int")
    })
    @ResponseBody
    @GetMapping("/queryPage")
    public PageBean queryPage(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String company,
                              @RequestParam(required = false) String spare01,
                              @RequestParam(required = false,defaultValue = "1") int pageNum,
                              @RequestParam(required = false,defaultValue = "10") int pageSize, HttpServletResponse response)throws Exception{
        if(pageNum < 0 || pageSize < 0){
            /**判断pageNum pageSize参数传值是否正确，不正确返回相应错误码*/
            ResponseUtil.response(response,ResponseUtil.PRAAMETER_ERROR);
        }

        List<Factorymanage> factorymanages = null;
        if(StringUtils.isNotBlank(spare01)){
            factorymanages = factoryService.selectOtherBySpare01(spare01);
        }else if(StringUtils.isNotBlank(name)){
            factorymanages = factoryService.selectByName(name);
            if(StringUtils.isNotBlank(company)){
                factorymanages = factoryService.selectByNameAndCompany(name,company);
            }
        }else if(StringUtils.isNotBlank(company)){
            factorymanages = factoryService.selectByCompany(company);
        }else {
            /**查询所有数据*/
            factorymanages = factoryService.select();
        }

        int totalRecord = factorymanages.size();
        PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 所有数据*/
        List<Factorymanage> pageMaterials = PageResult.ListSplit(factorymanages, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;
    }
}
