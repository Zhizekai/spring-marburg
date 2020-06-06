package com.tjpu.zzk.config.auth.smscode;

import java.time.LocalDateTime;

public class SmsCode {


    private String code;  //短信验证码

    private LocalDateTime expireTime; //验证码失效时间

    private String mobile; //手机号

    public SmsCode(String code, int expireAfterSeconds,String mobile){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireAfterSeconds);
        this.mobile = mobile;
    }

    //验证码是否失效
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public String getMobile() {
        return mobile;
    }
}
