package com.tjpu.zzk.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CaptchaImageVO {

    //验证码文字
    private String code;
    //验证码失效时间
    private LocalDateTime expireTime;
 
    public CaptchaImageVO(String code, int expireAfterSeconds){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireAfterSeconds);
    }
 
    //验证码是否失效
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }
}