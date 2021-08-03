package com.luer.comm.utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Api(description = "查询结果集分页工具类")
public class PageResult {

    @ApiModelProperty(name="page",value="第几页")
    private int pageNum;
    @ApiModelProperty(name="pageSize",value="一页显示多少条")
    private int pageSize;
    @ApiModelProperty(name="total",value="总记录数")
    private int total;

    /*private List ListSplit(List list) {
        List newList=null;
        total=list.size();
        newList=list.subList(row*(page-1), ((row*page)>total?total:(row*page)));
        return newList;
    }*/

    public static List ListSplit(List list,int pageSize,int pageNum) {
        List newList=null;
        int total=list.size();
        newList=list.subList(pageSize*(pageNum-1), ((pageSize*pageNum)>total?total:(pageSize*pageNum)));
        return newList;
    }
}
