package com.luer.demo.test;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrimaryGenerater {
    private static String SERIAL_NUMBER = "0001" ;
    private static PrimaryGenerater primaryGenerater = null;

    private PrimaryGenerater(){

    }

    /**
     * 取得PrimaryGenerater的单例实现
     *
     * @return
     */
    public static PrimaryGenerater getInstance() {
        if (primaryGenerater == null) {
            synchronized (PrimaryGenerater.class) {
                if (primaryGenerater == null) {
                    primaryGenerater = new PrimaryGenerater();
                }
            }
        }
        System.out.println("primaryGenerater: "+primaryGenerater);
        return primaryGenerater;
    }



    /**
     * 生成 日期+随机数的流水号
     * */
    public String getNumberForPK(){
        String id="";
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String temp = sf.format(new Date());
        int random=(int) (Math.random()*10000);
        id=temp+random;
        System.out.println("id:"+id);
        return id;
    }



    /**
     * HHTG+年月+8+0001
     * 每月从0001开始计数
     * */
    public static synchronized String getnumber(String thisCode){

        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");
        String thisData = thisCode.substring(4, 8);
        //这个判断就是判断你数据取出来的最后一个业务单号是不是当月的
        if(!formatter.format(date).equals(thisData)){
            System.out.println("新的一月");
            thisData = formatter.format(date);
            //如果是新的一月的就直接变成0001
            id = "HHTG" + thisData + "80001";
        }else{
            System.out.println("当月");
            DecimalFormat df = new DecimalFormat("0000");

            //不是新的一月就累加
            id ="HHTG"+ formatter.format(date)+"8"
                    + df.format(1 + Integer.parseInt(thisCode.substring(9, 13)));
        }
        System.out.println("id:"+id);
        return id;
    }



    public static void main(String[] args){
        /**
         *  HHTG170980001
         *  HH公司简称  + TG业务类型 + 年月 + 8部门 + 0001
         *
         *  */
        String sno = "HHTG170980001";
        System.out.println(getnumber(sno));
    }
}