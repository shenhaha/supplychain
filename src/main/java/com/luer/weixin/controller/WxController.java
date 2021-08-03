package com.luer.weixin.controller;


import com.luer.comm.utils.UUIDUtils;
import com.luer.weixin.bean.Accesstoken;
import com.luer.weixin.bean.Openid;
import com.luer.weixin.bean.User;
import com.luer.weixin.service.OpenidService;
import com.luer.weixin.service.UserService;
import com.luer.weixin.utils.HttpUtil;
import com.vdurmont.emoji.EmojiParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/weixin")
public class WxController {



    @Autowired
    OpenidService openidService;
    @Autowired
    UserService userService;

    public final static String APPID = "wx4a73c3eff285a854";
    public final static String APPSECRET = "22fc121146f502f042c28cc8111e7500";
    private Accesstoken at;

    @RequestMapping("/getToken")
    @ResponseBody
    public Accesstoken getToken() {
        String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String requestUrl = TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        JSONObject accessTokenStr = HttpUtil.httpsRequest(requestUrl, "GET", null);
        JSONObject jsonObject = JSONObject.fromObject(accessTokenStr);
        String accessToken = jsonObject.getString("access_token");
        String expireIn = jsonObject.getString("expires_in");
        at = new Accesstoken(accessToken, expireIn);
        return at;
    }

    @RequestMapping("/getAccessToken")
    @ResponseBody
    public String getAccessToken() {
        if (at == null || at.isExpireIn()) {
            getToken();
        }
        return at.getAccesstoken();
    }

    int total;
    List<String> strings;

    //手动获取所有openid
    @ResponseBody
    @RequestMapping("/getOpenid")
    public JSONObject getOpenid() {

        String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
        //当数据量很大是（万级以上）填写next_openid 再次请求拉取openid数据
        String requestUrl = TOKEN_URL.replace("ACCESS_TOKEN", getAccessToken()).replace("NEXT_OPENID", "oeMjz0hotX6tCePNUPk6CJA8yBIY");
        JSONObject accessTokenStr = HttpUtil.httpsRequest(requestUrl, "GET", null);
        //字符串转json
        JSONObject jsonObject = JSONObject.fromObject(accessTokenStr);

        //从json里取值
        total = jsonObject.getInt("total");
        int count = jsonObject.getInt("count");
        String data = jsonObject.getString("data");
        String next_openid = jsonObject.getString("next_openid");

        //打印
        System.out.println("total:" + total);
        System.out.println("count:" + count);
        System.out.println("next_openid:" + next_openid);
        System.out.println("data: " + data);
        JSONObject jsonObjectOpenid = JSONObject.fromObject(data);
        String openid = jsonObjectOpenid.getString("openid");
        //openid转为list数组
        JSONArray jsonArray = JSONArray.fromObject(openid);
        strings = JSONArray.toList(jsonArray, String.class);
        Openid openid1 = new Openid();

        for(int cnt=0;cnt<strings.size();cnt++){
            //封装数据对象
            openid1.setCreateTime(new Date());
            openid1.setUpdateTime(new Date());
            openid1.setOpenid(strings.get(cnt));
            //保存
            openidService.insert(openid1);
        }
        return jsonObject;

    }


    //手动保存所有用户详细信息
    @ResponseBody
    @RequestMapping("/secletOpenidList")
    public int secletOpenidList(){
        //查询数据接所有openid的集合
        List<String> openidlist = openidService.selectOpenidList();
        //21632  52135 无法保存符号
        for(int openidStr=0;openidStr<openidlist.size();openidStr++) {
            //获得请求url
            String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
            String requestUrl = TOKEN_URL.replace("ACCESS_TOKEN", getAccessToken()).replace("OPENID", openidlist.get(openidStr));
            //请求
            JSONObject accessTokenStr = HttpUtil.httpsRequest(requestUrl, "GET", null);
            JSONObject jsonObject = JSONObject.fromObject(accessTokenStr);
            System.out.println("jsonObject: "+jsonObject);

            //封装一个对象
            User user = new User();
            user.setId(UUIDUtils.getUUID());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setAppid("wx4a73c3eff285a854");
            String city = jsonObject.getString("city");
            user.setCity(city);
            String country = jsonObject.getString("country");
            user.setCountry(country);
            String headimgurl = jsonObject.getString("headimgurl");
            user.setHeadimgurl(headimgurl);
            String nickname = jsonObject.getString("nickname");
            nickname = EmojiParser.removeAllEmojis(nickname);
            user.setNickname(nickname);
            String openidusif = jsonObject.getString("openid");
            user.setOpenid(openidusif);
            String province = jsonObject.getString("province");
            user.setProvince(province);
            String remark = jsonObject.getString("remark");
            user.setRemark(remark);
            String sex = jsonObject.getString("sex");
            user.setSex(sex);
            String subscribe = jsonObject.getString("subscribe");
            user.setSubscribe(subscribe);
            String subscribe_scene = jsonObject.getString("subscribe_scene");
            user.setSubscribeScene(subscribe_scene);
            //保存
            userService.insert(user);
        }

        return openidlist.size();
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public void getUserInfo() {
        getOpenid();

        String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        System.out.println("strings:  " + strings);
        System.out.println(total);
        int flag = 0;

        for (int i = 10001; i < total; i++) {
            flag++;
            System.out.println(flag);
            String requestUrl = TOKEN_URL.replace("ACCESS_TOKEN", getAccessToken()).replace("OPENID", strings.get(i));
            JSONObject accessTokenStr = HttpUtil.httpsRequest(requestUrl, "GET", null);
            JSONObject jsonObject = JSONObject.fromObject(accessTokenStr);
            System.out.println(jsonObject);

            User user = new User();
            user.setId(UUIDUtils.getUUID());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setAppid("wx4a73c3eff285a854");

            String city = jsonObject.getString("city");
            user.setCity(city);

            String country = jsonObject.getString("country");
            user.setCountry(country);

            String headimgurl = jsonObject.getString("headimgurl");
            user.setHeadimgurl(headimgurl);


            String nickname = jsonObject.getString("nickname");
            nickname = EmojiParser.removeAllEmojis(nickname);
            user.setNickname(nickname);


            String openidusif = jsonObject.getString("openid");

            user.setOpenid(openidusif);

            String province = jsonObject.getString("province");
            user.setProvince(province);

            String remark = jsonObject.getString("remark");
            user.setRemark(remark);
            String sex = jsonObject.getString("sex");
            user.setSex(sex);
            String subscribe = jsonObject.getString("subscribe");
            user.setSubscribe(subscribe);
            //wxService.insertUserInfo(user);
        }

        System.out.println(flag);

    }


}


/*
我的测试号
* wxb10ee5d58f5cf24e
* e17eb9c3a0001784d55483c01ea8dd5f
*
*
* yuewei   11 26
* wxb10ee5d58f5cf24e
* cd3c0c0a072805cd1afe08b15cd47ee5
*
*
* yuewei   12 04
* wxb18a8434a169e801
* 92ba2a40bb6b873b38de17efe1c5d0ef
*
* */


