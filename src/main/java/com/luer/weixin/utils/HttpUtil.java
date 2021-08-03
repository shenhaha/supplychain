package com.luer.weixin.utils;

import com.luer.weixin.bean.Accesstoken;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;


@RestController
@RequestMapping("/util")
public class HttpUtil {

    public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public final static String appid = "wxb10ee5d58f5cf24e";
    public final static String appsecret = "e17eb9c3a0001784d55483c01ea8dd5f";


    /*
    * get请求  outputStr 为null
    * */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        System.out.println("httpsRequest");
        try {
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);

            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    @RequestMapping("/token")
    @ResponseBody
    public Accesstoken getToken() {
        Accesstoken accessToken = null;
        String requestUrl = token_url.replace("APPID", "wxb10ee5d58f5cf24e").replace("APPSECRET", "e17eb9c3a0001784d55483c01ea8dd5f");
        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

       /* String total = jsonObject.getString("total");

        System.out.println(total);
        JSONObject totaljson = JSONObject.fromObject(total);

        String total1 = jsonObject.getString("total");

        System.out.println(total1);*/

        if (null != jsonObject) {
            try {
                accessToken = new Accesstoken();
                accessToken.setAccesstoken(jsonObject.getString("access_token"));
                accessToken.setAccesstoken(jsonObject.getString("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                e.printPartialStackTrace(null);
            }
        }
        return accessToken;
    }


}


