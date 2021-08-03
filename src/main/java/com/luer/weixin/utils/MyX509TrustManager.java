package com.luer.weixin.utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 绫诲悕: MyX509TrustManager </br>
 * 鎻忚堪: 淇′换绠＄悊鍣� </br>
 * 寮�鍙戜汉鍛橈細 fj </br>
 * 鍒涘缓鏃堕棿锛� 聽2018-6-12 </br>
 * 鍙戝竷鐗堟湰锛歏1.0 聽</br>
 * 聽
 */
public class MyX509TrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
