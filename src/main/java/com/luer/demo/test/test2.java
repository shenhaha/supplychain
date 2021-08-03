package com.luer.demo.test;

import com.luer.comm.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;

public class test2 {

    public static void main(String [] args){
            if(StringUtils.isBlank(" ")){
                System.out.println("null");
            }
            if(StringUtils.isNotBlank("ok")){
                System.out.println("ok");
            }
            String token = "efbe4e872292e8419ca3dd3599419121#21232f297a57a5a743894a0e4a801fc3#21232f297a57a5a743894a0e4a801fc3";
            String[] t = token.split("#");
            System.out.println(t[0]);
            System.out.println(t[1]);
            System.out.println(t[2]);
            String t_id = MD5Util.convertMD5((t[0]));
            String t_username = MD5Util.convertMD5(t[1]);
            String t_password = MD5Util.convertMD5(MD5Util.convertMD5(t[2]));
            System.out.println(t_id);
        System.out.println(t_username);System.out.println(t_password);

    }

}
