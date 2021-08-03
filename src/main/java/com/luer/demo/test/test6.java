package com.luer.demo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();
        // 设置传入的时间格式
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy");
        // get到当前年份,需要完整时间则将“yyyy”改成“yyyy-MM-dd HH:mm:ss:SSS”
        String strYear = simpledateformat.format(calendar.getTime());
        //截取用户id最后六位字符，UMI=“000011”
        String UMI="CE2017000011".substring(7, 12);
        //将之转换成数字，+1后再转成字符串，num="12"
        String num=""+(Integer.parseInt(UMI)+1);
        //获取数字前所需0的个数
        int lenZero=6-num.length();
        //将相应个数的0添加到字符串中，num="000012"
        for(int i=0;i<lenZero;i++)
            num="0"+num;
        //将新的用户id标记年份以及数字拼接起来，userId=“CE2017000012”
        String userId="CE"+strYear+num;
        System.out.println(userId);
    }

}
