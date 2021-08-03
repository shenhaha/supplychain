package com.luer.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class test4 {

    public static void main(String[] args) {
        String fileName = "cgd";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateStr = format.format(new Date());
        fileName += dateStr + "001";
        System.out.println(fileName);
        test();
    }


    public static void test(){
        AtomicInteger id=new AtomicInteger(0);
        for(int i=0;i<10;i++){
            System.out.println(id.incrementAndGet());
        }
    }
}
