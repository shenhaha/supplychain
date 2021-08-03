package com.luer.demo.test;

import org.apache.commons.codec.digest.DigestUtils;

public class test1 {
       public static void main(String [] args)throws Exception{
        String text = "text";
        String key = "key";
        String md5 = "2da42e99d59372135b00c4a0a61ba191";
        //md5(text,key);
        verify(text,key,md5);
    }
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr=DigestUtils.md5Hex(text + key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }


    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }else{
            System.out.println("MD5验证失败");
        }

        return false;
    }

}
