package com.luer.demo.test;


import java.util.concurrent.atomic.AtomicInteger;

public class test5 {

    private static AtomicInteger count = new AtomicInteger();

    /**
     * 传入相应的前缀生成自增的ID
     *
     * @param end     上一次结束的ID编号
     * @param groupID 字符串
     * @param s       传入前缀
     * @return 生成自增的ID
     */
   /*public static String getQualityNum(String s, String groupID, int end) {
        count.set(end);
        count.incrementAndGet();
        Integer i = count.get();
        //获取当前的年
        long nowTimeStamp = SKTools.getNowTimeStamp();
        DateStringInfo dateStrByTimestamp = SKTools.getDateStrByTimestamp(nowTimeStamp);
        String year = dateStrByTimestamp.getYear();
        //将传入的前缀与项目部以及年拼接在以一起
        String format = StrUtil.format("{}{}{}", s, groupID, year);
        String strNum = StrUtil.format("{}", 100000 + i);
        //将1截取下来得到剩余的
        String substring = strNum.substring(1);
        //进行拼接并返回

        return StrUtil.format("{}{}", format, substring);
    }*/

}
