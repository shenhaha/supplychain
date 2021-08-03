package com.luer.basicsetup.controller;

import com.luer.basicsetup.bean.ExampleVo;
import com.luer.basicsetup.bean.Goodsmessage;
import com.luer.basicsetup.bean.Suppliermanage;
import com.luer.basicsetup.service.SupplierService;
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
@RequestMapping("/supplier")
@Api(description = "供应商管理接口")
public class SupplierController {


    @Autowired
    SupplierService supplierService;

    @CrossOrigin
    @ApiOperation(value = "添加供应商信息", notes = "添加供应商信息", httpMethod = "POST")
    @ApiImplicitParam(name = "suppliermanage", value = "Suppliermanage", required = true, dataType = "Suppliermanage")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet save(@RequestBody Suppliermanage suppliermanage) {
        /**单位编码唯一*/
        List<Suppliermanage> suppliermanages = supplierService.selectByUnitCode(suppliermanage.getUnitCode());
        if(suppliermanages.isEmpty()){
            supplierService.insert(suppliermanage);
            return ResultSet.getSuccess();
        }else {
            return ResultSet.getFail("单位编码已存在!");
        }
    }

    @CrossOrigin
    @ApiOperation(value = "根据ids批量删除供应商信息", notes = "根据ids批量删除供应商信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo(ids)", value = "供应商信息id数组对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/delete")
    public ResultSet delete(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        supplierService.deleteByIds(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "修改供应商信息", notes = "修改供应商信息 传入一个Suppliermanagee对象", httpMethod = "POST")
    @ApiImplicitParam(name = "suppliermanage", value = "Suppliermanage对象", required = true, dataType = "Suppliermanage")
    @ResponseBody
    @PostMapping(value = "/update")
    public ResultSet update(@RequestBody Suppliermanage suppliermanage) {
        supplierService.updateById(suppliermanage.getId(), suppliermanage);
        Suppliermanage suppliermanage1 = supplierService.selectById(suppliermanage.getId());
        return ResultSet.getSuccess(suppliermanage1);
    }

   @CrossOrigin
    @ApiOperation(value = "根据单位编码查询供应商", notes = "根据单位编码查询供应商", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectUNameByUcode")
    public String selectUNameByUcode(String unitCode,HttpServletResponse response) throws  Exception{
        String unitName = supplierService.selectUNameByUcode(unitCode);
        /**对list集合进行判空*/
        if (unitName == null) {
            //为空
            ResponseUtil.response(response, ResponseUtil.DATA_NULL);
        }
        return unitName;
    }


    @CrossOrigin
    @ApiOperation(value = "查询全部信息", notes = "查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectByClassName")
    public ResultSet selectByClassName(String className) {
        List<Suppliermanage> suppliermanages = supplierService.selectByClassName(className);
        /**对list集合进行判空*/
        if (suppliermanages.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(suppliermanages);
    }

    @CrossOrigin
    @ApiOperation(value = "查询全部信息", notes = "查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/select")
    public ResultSet select() {
        List<Suppliermanage> suppliermanages = supplierService.select();
        /**对list集合进行判空*/
        if (suppliermanages.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(suppliermanages);
    }


    @CrossOrigin
    @ApiOperation(value = "供应商信息页分查询", notes = "供应商信息页分查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String"),
            @ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "String"),
            @ApiImplicitParam(name = "className", value = "类别名称", dataType = "String"),
            @ApiImplicitParam(name = "spare01", value = "其他查询", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int")
    })
    @GetMapping("/queryPage")
    public PageBean queryPage(@RequestParam(required = false) String unitName,
                              @RequestParam(required = false) String phoneNumber,
                              @RequestParam(required = false) String className,
                              @RequestParam(required = false) String spare01,
                              @RequestParam(required = false, defaultValue = "1") int pageNum,
                              @RequestParam(required = false, defaultValue = "10") int pageSize, HttpServletResponse response) throws Exception {
        if (pageNum < 0 || pageSize < 0) {
            /**判断pageNum pageSize参数传值是否正确，不正确返回相应错误码*/
            ResponseUtil.response(response, ResponseUtil.PRAAMETER_ERROR);
        }
        List<Suppliermanage> suppliermanages = null;

        if (StringUtils.isBlank(unitName) && StringUtils.isBlank(phoneNumber)
                && StringUtils.isBlank(className) && StringUtils.isBlank(spare01)) {
            /**查询所有数据*/
            suppliermanages = supplierService.select();
        }

        if (StringUtils.isNotBlank(className)) {
            if (className.equals("全部")) {
                //**查询所有数据*//*
                suppliermanages = supplierService.select();
                if(StringUtils.isNotBlank(spare01)){
                    suppliermanages = supplierService.selectOtherBySpare01(spare01);

                }else if (StringUtils.isNotBlank(unitName)) {
                    suppliermanages = supplierService.selectByUnitName(unitName);
                    if (StringUtils.isNotBlank(phoneNumber)) {
                        suppliermanages = supplierService.selectByUnitNameAndPhoneNumber(unitName, phoneNumber);
                    }
                } else if (StringUtils.isNotBlank(phoneNumber)) {
                    suppliermanages = supplierService.selectByPhoneNumber(phoneNumber);
                }

            } else if (className.equals("原材料供应商")) {
                //**查询所有原材料供应商的信息*//*
                suppliermanages = supplierService.selectByClassName(className);
                if(StringUtils.isNotBlank(spare01)){
                    suppliermanages = supplierService.selectOtherYBySpare01(spare01);

                }else if (StringUtils.isNotBlank(unitName)) {
                    suppliermanages = supplierService.selectYByUnitName(unitName);
                    if (StringUtils.isNotBlank(phoneNumber)) {
                        suppliermanages = supplierService.selectYByUnitNameAndPhoneNumber(unitName, phoneNumber);
                    }
                } else if (StringUtils.isNotBlank(phoneNumber)) {
                    suppliermanages = supplierService.selectYByPhoneNumber(phoneNumber);
                }

            } else if (className.equals("辅料供应商")) {
                //**查询所有辅料供应商的信息*//*
                suppliermanages = supplierService.selectByClassName(className);
                if(StringUtils.isNotBlank(spare01)){
                    suppliermanages = supplierService.selectOtherFBySpare01(spare01);

                }else if (StringUtils.isNotBlank(unitName)) {
                    suppliermanages = supplierService.selectFByUnitName(unitName);
                    if (StringUtils.isNotBlank(phoneNumber)) {
                        suppliermanages = supplierService.selectFByUnitNameAndPhoneNumber(unitName, phoneNumber);
                    }
                } else if (StringUtils.isNotBlank(phoneNumber)) {
                    suppliermanages = supplierService.selectFByPhoneNumber(phoneNumber);
                }
            }
        }

        if (suppliermanages.isEmpty()) {
            ResponseUtil.response(response, ResponseUtil.DATA_NULL);
        }

        int totalRecord = suppliermanages.size();
        PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 所有数据*/
        List<Goodsmessage> pageMaterials = PageResult.ListSplit(suppliermanages, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;

    }

}


