package com.luer.comm.utils;


import io.swagger.annotations.Api;

import java.text.SimpleDateFormat;
import java.util.Date;

@Api(description = "生成入库单号工具类")
public class ODDNumberUtil {


    public static void main(String [] args){
        //System.out.println(CreatePNumber("0002"));
        //System.out.println(substring(CreatePNumber("0002")));
        //System.out.println(judgeNewDay("20190320"));
        //substr();
        System.out.println(CreatePNumber("CGD2019032100003"));
    }

    /***创建商品采购单号 pNumber为数据库中最后创建的采购单号*/
    public static String CreatePNumber(String pNumber){
        String purchaseNumber = null;
        if(judgeNewDay(substr(pNumber))) {
            /**判断为当天*/
            purchaseNumber = CreateDate()+CreateSerialnumber(substring(pNumber));
        }else{
            /**判断为新的一天*/
            purchaseNumber = CreateDate()+"00001";
        }
        return purchaseNumber;
    }




    /**获得当日日期字符串*/
    public static String CreateDate() {
        String fileName = "RKD";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateStr = format.format(new Date());
        fileName += dateStr;
        //System.out.println("fileName: "+fileName);
        return fileName;
    }




    /**获取五位自增流水号*/
    public static String CreateSerialnumber(String param) {
        if (param == null) {
            param = "00000";
        }
        int s = Integer.parseInt(param);
        s = ++s;
        s = s == 100000 ? 1 : s;  //这里将规定最大数字设定为小于100000
        String reslut = s >= 10 ? (s >= 100 ? (s >= 1000 ? (s >= 10000 ? s + "" : "0" + s) : "00" + s) : "000" + s) : "0000" + s; // 计算 转型  
        // System.out.println("reslut: "+reslut);
        return reslut;
    }

    /**获得最后字符串五位*/
    public static String substring(String str){

        //String str = "CGD2019031900003";
        String result = null;
        int length = str.length();
        if(length >= 5){
            result = str.substring(length-5, length);
        }else{
            result = "error";
        }
        return result;
    }

    /**获取字符串中间若干位*/
    public static String substr(String str){
        //String str  = "CGD2019032000003";
        String strs = str.substring(3,11);
        return strs;
    }


    /**判断日期字符串和当日是否相同*/
    public static boolean judgeNewDay(String time){
        //String time = "20190320";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateStr = format.format(new Date());
        if(time.equals(dateStr)){
            return true;
        }else {
            return false;
        }
    }








}

