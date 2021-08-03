package com.luer.weixin.bean;

public class Accesstoken {
    private String id;

    private String accesstoken;

    private String expirein;

    private long expiresTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }

    public String getExpirein() {
        return expirein;
    }

    public void setExpirein(String expirein) {
        this.expirein = expirein == null ? null : expirein.trim();
    }


    public Accesstoken(){
        super();
    }

    public Accesstoken(String accesstoken,String expirein){
        super();
        this.accesstoken = accesstoken;
        this.expirein = expirein;
        expiresTime = System.currentTimeMillis()+Integer.parseInt(expirein)*1000;

    }
    /*
            * 判断token是否过期
     * */
    public boolean isExpireIn(){
        return System.currentTimeMillis()>expiresTime;
    }
}