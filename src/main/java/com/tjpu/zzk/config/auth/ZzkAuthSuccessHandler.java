package com.tjpu.zzk.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjpu.zzk.config.exception.AjaxResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ServerCloneException;

@Component
public class ZzkAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Value("${spring.security.loginType}")
    private String loginType;  //用json的方式登陆
    private static ObjectMapper objectMapper = new ObjectMapper(); //将对象和json转换

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws ServletException, IOException {

        if (loginType.equalsIgnoreCase("JSON")) {

            httpServletResponse.setContentType("application/json;charset=UTF-8"); //以json的形式相应
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(
                    AjaxResponse.success("/index"))); //写回json

        }else {

            //跳转到登陆之前请求的页面
            super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
        }



    }
}
