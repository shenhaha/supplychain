package com.luer.basicsetup.controller;

import com.luer.basicsetup.bean.ExampleVo;
import com.luer.basicsetup.bean.Goodsmessage;
import com.luer.basicsetup.bean.Materialmessage;
import com.luer.basicsetup.service.GoodsmessageService;
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
@RequestMapping("/goodsmessage")
@Api(description = "商品信息档案接口")
public class GoodsmessageController {

    @Autowired
    GoodsmessageService goodsmessageService;

    @CrossOrigin
    @ApiOperation(value = "添加商品信息", notes = "添加商品信息", httpMethod = "POST")
    @ApiImplicitParam(name = "goodsmessage", value = "Goodsmessage对象", required = true, dataType = "Goodsmessage")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet saveGoodsmessage(@RequestBody Goodsmessage goodsmessage) {
        /**商家编码 条形码不能重复 需要判断*/
        List<Goodsmessage> goodsmessages = goodsmessageService.selectByMerchantCode(goodsmessage.getMerchantCode());
        List<Goodsmessage> goodsmessages1 = goodsmessageService.selectByBarCode(goodsmessage.getBarCode());
        if(!goodsmessages.isEmpty()){
            return ResultSet.getFail("商家编码已存在!");
        }else if(!goodsmessages1.isEmpty()){
            return ResultSet.getFail("条形码已存在!");
        }else if(goodsmessages.isEmpty() && goodsmessages1.isEmpty()){
            goodsmessageService.insert(goodsmessage);
        }
        return ResultSet.getSuccess();
    }

    @CrossOrigin
    @ApiOperation(value="根据ids批量删除商品信息", notes="根据ids批量删除商品信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo(ids)", value = "商品信息id数组对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/delete")
    public ResultSet delete(@RequestBody ExampleVo vo){
        List<String> list = vo.getIds();
        if(list.isEmpty()){
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        goodsmessageService.deleteByIds(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "修改商品信息", notes = "修改商品信息 传入一个Goodsmessage对象", httpMethod = "POST")
    @ApiImplicitParam(name = "goodsmessage", value = "Goodsmessage对象", required = true, dataType = "Goodsmessage")
    @ResponseBody
    @PostMapping(value="/update")
    public ResultSet  updateGoodsmessage(@RequestBody Goodsmessage goodsmessage){
        goodsmessageService.updateById(goodsmessage.getId(),goodsmessage);
        Goodsmessage goodsmessage1 = goodsmessageService.selectById(goodsmessage.getId());
        return ResultSet.getSuccess(goodsmessage1);
    }

    @CrossOrigin
    @ApiOperation(value = "查询全部信息", notes = "查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/select")
    public ResultSet select(){
        List<Goodsmessage> goodsmessages = goodsmessageService.select();
        /**对list集合进行判空*/
        if(goodsmessages.isEmpty() ){
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(goodsmessages);
    }

    @CrossOrigin
    @ApiOperation(value = "恢复回收站中的商品信息为可用信息", notes = "恢复回收站中的商品信息为可用信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "商品信息id集合对象 ", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateByOpen")
    public ResultSet updateBySpare01Open(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        goodsmessageService.updateBySpare01Open(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "把商品信息放入回收站", notes = "把商品信息放入回收站", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "原材料信息id集合对象 ", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateByOut")
    public ResultSet updateBySpare01Out(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        goodsmessageService.updateBySpare01Out(arr);
        return ResultSet.getSuccess(arr);
    }


    @CrossOrigin
    @ApiOperation(value = "回收站商品信息分页查询", notes = "回收站商品信息分页查询", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "merchantCode", value = "商家编码", dataType = "String"),
                        @ApiImplicitParam(name = "name", value = "商品名称", dataType = "String"),
                        @ApiImplicitParam(name = "other", value = "其他",  dataType = "string"),
                        @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
                        @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int"),
    })
    @ResponseBody
    @GetMapping("/queryRecycle")
    public PageBean queryRecycle(
                     @RequestParam(required = false) String merchantCode,
                     @RequestParam(required = false) String name,
                     @RequestParam(required = false) String other,
                     @RequestParam(required = false, defaultValue = "1") int pageNum,
                     @RequestParam(required = false, defaultValue = "10") int pageSize, HttpServletResponse response) throws Exception {
        if (pageNum < 0 || pageSize < 0) {
            /**判断pageNum pageSize参数传值是否正确，不正确返回相应错误码*/
            ResponseUtil.response(response, ResponseUtil.PRAAMETER_ERROR);
        }
        PageBean pageBean = null;
        List<Goodsmessage> goodsmessages = null;

        if(StringUtils.isNotBlank(merchantCode)){
            goodsmessages = goodsmessageService.selectByMerchantCodeR(merchantCode);
        }else if(StringUtils.isNotBlank(name)){
            goodsmessages = goodsmessageService.selectByNameR(name);
        }else if(StringUtils.isNotBlank(other)){
            goodsmessages = goodsmessageService.selectByOtherR(other);
        }else {
            goodsmessages = goodsmessageService.selectRecycle();
        }

        if (goodsmessages.isEmpty()) {
            ResponseUtil.response(response, ResponseUtil.RECYCLE_NULL);
            pageBean.setMsg("回收站无数据");
        }
        int totalRecord = goodsmessages.size();
        pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 相应类型数据*/
        List<Materialmessage> pageMaterials = PageResult.ListSplit(goodsmessages, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;
    }


    @CrossOrigin
    @ApiOperation(value="商品信息分页查询", notes="商品信息页分查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merchantCode", value = "商家编码",dataType = "String"),
            @ApiImplicitParam(name = "name", value = "物料名称", dataType = "String" ),
            @ApiImplicitParam(name = "sku", value = "盒装sku",  dataType = "string"),
            @ApiImplicitParam(name = "itemCode", value = "货品编号",  dataType = "string"),
            @ApiImplicitParam(name = "other", value = "其他",  dataType = "string"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int")
    })
    @ResponseBody
    @GetMapping("/queryPage")
    public PageBean queryPage(@RequestParam(required = false) String merchantCode,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String itemCode,
                              @RequestParam(required = false) String sku,
                              @RequestParam(required = false) String other,
                              @RequestParam(required = false,defaultValue = "1") int pageNum,
                              @RequestParam(required = false,defaultValue = "10") int pageSize, HttpServletResponse response)throws Exception{
        if(pageNum < 0 || pageSize < 0){
            /**判断pageNum pageSize参数传值是否正确，不正确返回相应错误码*/
            ResponseUtil.response(response,ResponseUtil.PRAAMETER_ERROR);
        }
        PageBean pageBean = new PageBean();
        List<Goodsmessage> goodsmessages = null;

        /**不传参，默认返回所有数据*/
        if (StringUtils.isBlank(merchantCode)  && StringUtils.isBlank(name) && StringUtils.isBlank(itemCode)
                && StringUtils.isBlank(sku) && StringUtils.isBlank(other)) {
            /**查询所有数据*/
            List<Goodsmessage> goodsmessages1 = goodsmessageService.select();
            int totalRecord = goodsmessages1.size();
            pageBean = new PageBean(pageNum, pageSize, totalRecord);
            /**对结果集进行分页 所有数据*/
            List<Goodsmessage> pageMaterials = PageResult.ListSplit(goodsmessages1, pageSize, pageNum);
            pageBean.setList(pageMaterials);
            pageBean.setMsg("success");
        } else {
            pageBean.setMsg("error");
        }

        if(StringUtils.isNotBlank(merchantCode)){
            goodsmessages = goodsmessageService.selectByMaterialCode(merchantCode);
            if(StringUtils.isNotBlank(name)){
                goodsmessages = goodsmessageService.selectByMaterialCodeAndName(merchantCode,name);
                if(StringUtils.isNotBlank(itemCode)){
                    goodsmessages = goodsmessageService.selectByMaterialCodeAndNameAndItemCode(merchantCode,name,itemCode);
                }else if(StringUtils.isNotBlank(sku)){
                    goodsmessages = goodsmessageService.selectByMaterialCodeAndNameAndSku(merchantCode,name,sku);
                }
            }else if(StringUtils.isNotBlank(itemCode)){
                goodsmessages = goodsmessageService.selectByMaterialCodeAndItemcode(merchantCode,itemCode);
                if(StringUtils.isNotBlank(sku)){
                    goodsmessages = goodsmessageService.selectByMaterialCodeAndItemCodeAndSku(merchantCode,itemCode,sku);
                }
            }else if(StringUtils.isNotBlank(sku)){
                goodsmessages = goodsmessageService.selectByMaterialCodeAndSku(merchantCode,sku);
            }

            if(StringUtils.isNotBlank(merchantCode) && StringUtils.isNotBlank(name)
                    && StringUtils.isNotBlank(itemCode) && StringUtils.isNotBlank(sku)){
                goodsmessages = goodsmessageService.selectByMaterialCodeAndNameAndItemCodeAndSku(merchantCode,name,itemCode,sku);
            }

        }else if(StringUtils.isNotBlank(name)){
            goodsmessages = goodsmessageService.selectByName(name);
            if(StringUtils.isNotBlank(itemCode)){
                goodsmessages = goodsmessageService.selectByNameAndItemCode(name,itemCode);
            }else if(StringUtils.isNotBlank(sku)){
                goodsmessages = goodsmessageService.selectByNameAndSku(name,sku);
            }
            if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(itemCode) && StringUtils.isNotBlank(sku)){
                goodsmessages = goodsmessageService.selectByNameAndItemCodeAndSku(name,itemCode,sku);
            }
        }else if(StringUtils.isNotBlank(itemCode)){
            goodsmessages = goodsmessageService.selectByItemCode(itemCode);
            if(StringUtils.isNotBlank(sku)){
                goodsmessages = goodsmessageService.selectByItemCodeAndSku(itemCode,sku);
            }
        }else if(StringUtils.isNotBlank(sku)){
            goodsmessages = goodsmessageService.selectBySku(sku);
        }else {
            /**查询所有数据*/
            goodsmessages = goodsmessageService.select();
        }

        if(StringUtils.isNotBlank(other)){
            goodsmessages = goodsmessageService.selectByOther(other);
        }

        if (goodsmessages.isEmpty()) {
            ResponseUtil.response(response, ResponseUtil.DATA_NULL);
        }
        int totalRecord = goodsmessages.size();
        pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 所有数据*/
        List<Materialmessage> pageMaterials = PageResult.ListSplit(goodsmessages, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;
    }
}
