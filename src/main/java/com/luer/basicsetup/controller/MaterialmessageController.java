package com.luer.basicsetup.controller;


import com.luer.basicsetup.bean.ExampleVo;
import com.luer.basicsetup.bean.Materialmessage;
import com.luer.basicsetup.service.MaterialmessageService;
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

@Api(description = "原材料信息接口")
@RequestMapping("/materialmessage")
@RestController
public class MaterialmessageController {

    @Autowired
    private MaterialmessageService materialmessageService;

    @CrossOrigin
    @ApiOperation(value = "添加原材料信息", notes = "添加原材料信息", httpMethod = "POST")
    @ApiImplicitParam(name = "materialmessage", value = "Materialmessage对象", required = true, dataType = "Materialmessage")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet saveMaterialmessage(@RequestBody Materialmessage materialmessage) {
        /**物料编码不能重复，需要判断 materialCode*/
        String materialCode = materialmessage.getMaterialCode();
        List<Materialmessage> materialmessages = materialmessageService.selectByMaterialCodeAll(materialCode);
        /**对list集合进行判空*/
        if (materialmessages.isEmpty()) {
            //为空
            materialmessageService.insert(materialmessage);
            return ResultSet.getSuccess(materialmessage);
        } else {
            //不为空
            return ResultSet.getFail("物料编码已存在");
        }
    }

    @CrossOrigin
    @ApiOperation(value = "根据ids批量删除原材料信息", notes = "根据ids批量删除原材料信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "商品信息id数组对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/deleteMaterialmessages")
    public ResultSet delete(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        materialmessageService.deleteByIds(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "修改原材料信息", notes = "修改原材料信息 传入一个Materialmessage对象", httpMethod = "POST")
    @ApiImplicitParam(name = "materialmessage", value = "Materialmessage对象", required = true, dataType = "materialmessage")
    @ResponseBody
    @PostMapping(value = "/update")
    public ResultSet updateMaterialmessage(@RequestBody Materialmessage materialmessage) {
        materialmessageService.updateById(materialmessage.getId(), materialmessage);
        Materialmessage materialmessage1 = materialmessageService.selectById(materialmessage.getId());
        return ResultSet.getSuccess(materialmessage1);
    }

    @CrossOrigin
    @ApiOperation(value = "根据ids启用原材料信息", notes = "根据ids启用原材料信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "原材料信息id集合对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateByIdOpen")
    public ResultSet updateByIdOpen(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        materialmessageService.updateByIdOpen(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "根据ids停用原材料信息", notes = "根据ids停用原材料信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "原材料信息id集合对象 ", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateByIdOut")
    public ResultSet updateByIdOut(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        materialmessageService.updateByIdOut(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "恢复回收站中的原材料信息为可用信息", notes = "恢复回收站中的原材料信息为可用信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "原材料信息id集合对象 ", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateByOpen")
    public ResultSet updateByDataStateOpen(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        materialmessageService.updateByDataStateOpen(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "把原材料信息放入回收站", notes = "把原材料信息放入回收站", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "原材料信息id集合对象 ", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateByOut")
    public ResultSet updateByDataStateOut(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        materialmessageService.updateByDataStateOut(arr);
        return ResultSet.getSuccess(arr);
    }


    @ApiOperation(value = "查询辅料信息", notes = "查询辅料信息(包括一般辅料和包装)", httpMethod = "GET")
    @ApiImplicitParam(name = "type", value = "辅料", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/selectByTypeAnd")
    public ResultSet selectByTypeAnd(String type) {
        if (StringUtils.isBlank(type)) {
            return ResultSet.getFail();
        }
        List<Materialmessage> materialmessages = materialmessageService.selectByTypeAnd(type);
        /**对list集合进行判空*/
        if (materialmessages.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(materialmessages);
    }


    @CrossOrigin
    @ApiOperation(value = "回收站原材料信息分页查询", notes = "回收站原材料信息分页查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int"),
            @ApiImplicitParam(name = "materialCode", value = "物料编码", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "物料名称", dataType = "String"),
    })
    @ResponseBody
    @GetMapping("/queryRecycle")
    public PageBean queryRecycle(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                  @RequestParam(required = false, defaultValue = "10") int pageSize,
                                  @RequestParam(required = false) String materialCode,
                                  @RequestParam(required = false) String name, HttpServletResponse response) throws Exception {
        if (pageNum < 0 || pageSize < 0) {
            /**判断pageNum pageSize参数传值是否正确，不正确返回相应错误码*/
            ResponseUtil.response(response, ResponseUtil.PRAAMETER_ERROR);
        }
        List<Materialmessage> typeMaterials = null;
        PageBean pageBean = null;

        if(StringUtils.isNotBlank(materialCode)){
            /**根据编码在所有回收站数据中查询*/
            typeMaterials = materialmessageService.selectByMaterialCodeR(materialCode);
            if(StringUtils.isNotBlank(name)){
                /**根据编码和名字在所有回收站数据中查询*/
                typeMaterials = materialmessageService.selectByMaterialCodeAndNameR(materialCode,name);
            }
        }else if(StringUtils.isNotBlank(name)){
            /**根据名字在所有回收站数据中查询*/
            typeMaterials = materialmessageService.selectByNameR(name);
        }else{
            /**查询所有回收站数据*/
            typeMaterials = materialmessageService.selectRecycle();
        }
        if (typeMaterials.isEmpty()) {
            ResponseUtil.response(response, ResponseUtil.RECYCLE_NULL);
            pageBean.setMsg("回收站无数据");
        }
        int totalRecord = typeMaterials.size();
        pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 相应类型数据*/
        List<Materialmessage> pageMaterials = PageResult.ListSplit(typeMaterials, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;
    }

    @CrossOrigin
    @ApiOperation(value = "原材料信息分页查询", notes = "原材料信息页分查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "原材料类型", dataType = "String", defaultValue = "1"),
            @ApiImplicitParam(name = "materialCode", value = "物料编码", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "物料名称", dataType = "String"),
            @ApiImplicitParam(name = "manufacturer", value = "厂商", dataType = "string"),
            @ApiImplicitParam(name = "spare", value = "启用状态", dataType = "string"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int")
    })
    @ResponseBody
    @GetMapping("/queryPage")
    public PageBean queryPage(@RequestParam(required = false) String type,
                              @RequestParam(required = false) String materialCode,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String manufacturer,
                              @RequestParam(required = false) String spare,
                              @RequestParam(required = false, defaultValue = "1") int pageNum,
                              @RequestParam(required = false, defaultValue = "10") int pageSize, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean();
        if (pageNum < 0 || pageSize < 0) {
            /**判断pageNum pageSize参数传值是否正确，不正确返回相应错误码*/
            ResponseUtil.response(response, ResponseUtil.PRAAMETER_ERROR);
        }
        /**不传参，默认返回所有数据*/
        if (StringUtils.isBlank(type) && StringUtils.isBlank(materialCode) && StringUtils.isBlank(name)
                && StringUtils.isBlank(manufacturer) && StringUtils.isBlank(spare)) {
            /**查询所有数据*/
            List<Materialmessage> materialmessages = materialmessageService.select();
            int totalRecord = materialmessages.size();
            pageBean = new PageBean(pageNum, pageSize, totalRecord);
            /**对结果集进行分页 所有数据*/
            List<Materialmessage> pageMaterials = PageResult.ListSplit(materialmessages, pageSize, pageNum);
            pageBean.setList(pageMaterials);
            pageBean.setMsg("success");
        } else {
            pageBean.setMsg("error");
        }
        List<Materialmessage> typeMaterials = null;
        if (StringUtils.isNotBlank(type)) {
            if (type.equals("全部")) {
                /**查询全部数据*/
                typeMaterials = materialmessageService.select();
                if (StringUtils.isNotBlank(materialCode)) {
                    /**根据编码在所有数据中查询*/
                    typeMaterials = materialmessageService.selectByMaterialCode(materialCode);
                    if (StringUtils.isNotBlank(name)) {
                        /**根据编码和名字在所有数据中查询*/
                        typeMaterials = materialmessageService.selectByMaterialCodeAndName(materialCode, name);
                    } else if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据编码和厂商在所有数据中查询*/
                        typeMaterials = materialmessageService.selectBymaterialCodeAndManufacturer(materialCode, manufacturer);
                    }
                } else if (StringUtils.isNotBlank(name)) {
                    /**根据名字在所有数据中查询*/
                    typeMaterials = materialmessageService.selectByName(name);
                    if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据厂商和名字在所有数据中查询*/
                        typeMaterials = materialmessageService.selectByManufacturerAndName(manufacturer, name);
                    }
                } else if (StringUtils.isNotBlank(manufacturer)) {
                    /**根据厂商在所有数据中查询*/
                    typeMaterials = materialmessageService.selectByManufacturer(manufacturer);
                }
                if (StringUtils.isNotBlank(materialCode) && StringUtils.isNotBlank(manufacturer) && StringUtils.isNotBlank(name)) {
                    /**根据编号，厂商和名字在所有数据中查询*/
                    typeMaterials = materialmessageService.selectByMaterialCodeAndManufacturerAndName(materialCode, manufacturer, name);
                }
            } else if (type.equals("原材料")) {
                /**根据原材料类型在所有数据中查询*/
                typeMaterials = materialmessageService.selectByType(type);
                if (StringUtils.isNotBlank(materialCode)) {
                    /**根据编码在所有原材料数据中查询*/
                    typeMaterials = materialmessageService.selectYByMaterialCode(materialCode);
                    if (StringUtils.isNotBlank(name)) {
                        /**根据编码和名字在所有原材料数据中查询*/
                        typeMaterials = materialmessageService.selectYByMaterialCodeAndName(materialCode, name);
                    } else if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据编码和厂商在所有原材料数据中查询*/
                        typeMaterials = materialmessageService.selectYBymaterialCodeAndManufacturer(materialCode, manufacturer);
                    }
                } else if (StringUtils.isNotBlank(name)) {
                    /**根据名字在所有原材料数据中查询*/
                    typeMaterials = materialmessageService.selectYByName(name);
                    if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据厂商和名字在所有原材料数据中查询*/
                        typeMaterials = materialmessageService.selectYByManufacturerAndName(manufacturer, name);
                    }
                } else if (StringUtils.isNotBlank(manufacturer)) {
                    /**根据厂商在所有原材料数据中查询*/
                    typeMaterials = materialmessageService.selectYByManufacturer(manufacturer);
                }
                if (StringUtils.isNotBlank(materialCode) && StringUtils.isNotBlank(manufacturer) && StringUtils.isNotBlank(name)) {
                    /**根据编码，厂商和名字在所有原材料数据中查询*/
                    typeMaterials = materialmessageService.selectYByMaterialCodeAndManufacturerAndName(materialCode, manufacturer, name);
                }
            } else if (type.equals("辅料")) {/**辅料包括包装和一般辅料*/
                typeMaterials = materialmessageService.selectByTypeAnd(type);
                if (StringUtils.isNotBlank(name)) {/**根据名字在辅料数据中查询*/
                    typeMaterials = materialmessageService.selectfuByName(name);
                    /**不一样*/
                } else if (StringUtils.isNotBlank(manufacturer)) {/**根据厂商在辅料数据中查询*/
                    typeMaterials = materialmessageService.selectfuByManufacturer(manufacturer);
                } else if (StringUtils.isNotBlank(materialCode)) {/**根据编码在辅料数据中查询*/
                    typeMaterials = materialmessageService.selectByMaterialCode(materialCode);
                }
            } else if (type.equals("包装")) {
                /**根据原材料类型在所有数据中查询*/
                typeMaterials = materialmessageService.selectByType(type);
                if (StringUtils.isNotBlank(materialCode)) {
                    /**根据编码在所有包装数据中查询*/
                    typeMaterials = materialmessageService.selectBByMaterialCode(materialCode);
                    if (StringUtils.isNotBlank(name)) {
                        /**根据编号和名字在所有包装数据中查询*/
                        typeMaterials = materialmessageService.selectBByMaterialCodeAndName(materialCode, name);
                    } else if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据编号和厂商在所有包装数据中查询*/
                        typeMaterials = materialmessageService.selectBBymaterialCodeAndManufacturer(materialCode, manufacturer);
                    }
                } else if (StringUtils.isNotBlank(name)) {
                    /**根据名字在所有包装数据中查询*/
                    typeMaterials = materialmessageService.selectBByName(name);
                    if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据厂商和名字在所有包装数据中查询*/
                        typeMaterials = materialmessageService.selectBByManufacturerAndName(manufacturer, name);
                    }
                } else if (StringUtils.isNotBlank(manufacturer)) {
                    /**根据厂商在所有包装数据中查询*/
                    typeMaterials = materialmessageService.selectBByManufacturer(manufacturer);
                }
                if (StringUtils.isNotBlank(materialCode) && StringUtils.isNotBlank(manufacturer) && StringUtils.isNotBlank(name)) {
                    /**根据编号，厂商和名字在所有包装数据中查询*/
                    typeMaterials = materialmessageService.selectBByMaterialCodeAndManufacturerAndName(materialCode, manufacturer, name);
                }
            } else if (type.equals("一般辅料")) {
                /**根据原材料类型在所有数据中查询*/
                typeMaterials = materialmessageService.selectByType(type);
                if (StringUtils.isNotBlank(materialCode)) {
                    /**根据编号在所有一般辅料数据中查询*/
                    typeMaterials = materialmessageService.selectYFByMaterialCode(materialCode);
                    if (StringUtils.isNotBlank(name)) {
                        /**根据编号和名字在所有一般辅料数据中查询*/
                        typeMaterials = materialmessageService.selectYFByMaterialCodeAndName(materialCode, name);
                    } else if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据编号和厂商在所有一般辅料数据中查询*/
                        typeMaterials = materialmessageService.selectYFBymaterialCodeAndManufacturer(materialCode, manufacturer);
                    }
                } else if (StringUtils.isNotBlank(name)) {
                    /**根据名字在所有一般辅料数据中查询*/
                    typeMaterials = materialmessageService.selectYFByName(name);
                    if (StringUtils.isNotBlank(manufacturer)) {
                        /**根据厂商和名字在所有一般辅料数据中查询*/
                        typeMaterials = materialmessageService.selectYFByManufacturerAndName(manufacturer, name);
                    }
                } else if (StringUtils.isNotBlank(manufacturer)) {
                    /**根据厂商在所有一般辅料数据中查询*/
                    typeMaterials = materialmessageService.selectYFByManufacturer(manufacturer);
                }
                if (StringUtils.isNotBlank(materialCode) && StringUtils.isNotBlank(manufacturer) && StringUtils.isNotBlank(name)) {
                    /**根据编号，厂商和名字在所有一般辅料数据中查询*/
                    typeMaterials = materialmessageService.selectYFByMaterialCodeAndManufacturerAndName(materialCode, manufacturer, name);
                }
            }


            if (typeMaterials.isEmpty()) {
                ResponseUtil.response(response, ResponseUtil.DATA_NULL);
            }
            int totalRecord = typeMaterials.size();
            pageBean = new PageBean(pageNum, pageSize, totalRecord);
            /**对结果集进行分页 相应类型数据*/
            List<Materialmessage> pageMaterials = PageResult.ListSplit(typeMaterials, pageSize, pageNum);
            pageBean.setList(pageMaterials);
            pageBean.setMsg("success");
        } else {
            pageBean.setMsg("error");
        }
        return pageBean;
    }

}
