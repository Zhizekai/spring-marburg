package com.tjpu.zzk.controller;


import com.tjpu.zzk.config.auth.MyUserDetails;
import com.tjpu.zzk.config.auth.MyUserDetailsServiceMapper;
import com.tjpu.zzk.config.auth.smscode.SmsCode;
import com.tjpu.zzk.config.exception.AjaxResponse;
import com.tjpu.zzk.config.exception.CustomException;
import com.tjpu.zzk.config.exception.CustomExceptionType;
import com.tjpu.zzk.utils.MyContants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class SmsController {

    @Resource
    MyUserDetailsServiceMapper myUserDetailsServiceMapper;

    @RequestMapping(value = "/smscode",method = RequestMethod.GET)
    public AjaxResponse sms(@RequestParam String mobile, HttpSession session) {


        MyUserDetails myUserDetails = myUserDetailsServiceMapper.findByUserName(mobile);

        //手机号没注册
        if (myUserDetails == null) {
            return AjaxResponse.error(
                    new CustomException(CustomExceptionType.USER_INPUT_ERROR,"你输入的手机号没注册")
            );
        }

        //创建一个新的手机验证码
        SmsCode smsCode = new SmsCode(
                RandomStringUtils.randomNumeric(4),60,mobile
        );

        //TODO 调用短信服务提供商接口发送短信

        log.info(smsCode.getCode() + "->" + mobile);
        session.setAttribute(MyContants.SMS_SESSION_KEY,smsCode);

        return AjaxResponse.success("短信验证码已经发送");
    }
}
