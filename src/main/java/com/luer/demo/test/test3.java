package com.luer.demo.test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test3 {
    public static void main(String [] args) throws Exception{

        Date date = new Date();
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(date);
        System.out.println(df2.format(date));
       // test();

    }

    public static void test() throws  Exception{
        String  time = "2019-02-27 17:20:18";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = sdf.parse(time);
        sdf.format(date);
        System.out.println(time);
        System.out.println(date);
    }
}
