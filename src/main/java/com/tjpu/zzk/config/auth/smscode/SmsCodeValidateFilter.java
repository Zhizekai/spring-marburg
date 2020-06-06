package com.tjpu.zzk.config.auth.smscode;

import com.tjpu.zzk.config.auth.MyAuthenticationFailureHandler;
import com.tjpu.zzk.config.auth.MyUserDetails;
import com.tjpu.zzk.config.auth.MyUserDetailsServiceMapper;
import com.tjpu.zzk.config.auth.imageCode.CaptchaCode;
import com.tjpu.zzk.utils.MyContants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Component
public class SmsCodeValidateFilter  extends OncePerRequestFilter {


    @Resource
    MyUserDetailsServiceMapper myUserDetailsServiceMapper;
    @Resource
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 必须是登录的post请求才能进行验证，其他的直接放行
        if(StringUtils.equals("/smslogin",request.getRequestURI())
                && StringUtils.equalsIgnoreCase(request.getMethod(),"post")){

            try{
                //1.验证谜底与用户输入是否匹配
                validate(new ServletWebRequest(request));
            }catch(AuthenticationException e){
                //2.捕获步骤1中校验出现异常，交给失败处理类进行进行处理
                myAuthenticationFailureHandler.onAuthenticationFailure(request,response,e);
                return; //终端过滤器链的执行
            }

        }
        //通过校验，就放行
        filterChain.doFilter(request,response);

    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {

        //取出session
        HttpSession session = request.getRequest().getSession();
        String mobileInRequest = request.getParameter("mobile");
        String codeInRequest = request.getParameter("smsCode");

        SmsCode codeInSession = (SmsCode)session.getAttribute(MyContants.SMS_SESSION_KEY);
        //获取用户登录界面输入的captchaCode
//        String codeInRequest = ServletRequestUtils.getStringParameter(
//                request.getRequest(),"captchaCode");

        if (StringUtils.isEmpty(mobileInRequest)) {
            throw  new SessionAuthenticationException("手机号码不能为空");
        }
        if(StringUtils.isEmpty(codeInRequest)){
            throw new SessionAuthenticationException("短信验证码不能为空");
        }

        // 获取session池中的验证码谜底
//        CaptchaCode codeInSession = (CaptchaCode) session.getAttribute(MyContants.CAPTCHA_SESSION_KEY);
        if(Objects.isNull(codeInSession)) {
            throw new SessionAuthenticationException("短信验证码不存在");
        }

        // 校验服务器session池中的验证码是否过期
        if(codeInSession.isExpired()) {
            session.removeAttribute(MyContants.CAPTCHA_SESSION_KEY);
            throw new SessionAuthenticationException("短信验证码已经过期");
        }

        // 请求验证码校验
        if(!codeInSession.getCode().equals(codeInRequest)) {
            throw new SessionAuthenticationException("短信验证码不正确");
        }

        if(!codeInSession.getMobile().equals(mobileInRequest)) {
            throw new SessionAuthenticationException("短信发送目标与您输入的手机号不一致");
        }

        MyUserDetails myUserDetails = myUserDetailsServiceMapper.findByUserName(mobileInRequest);
        if (Objects.isNull(myUserDetails)) {
            throw new SessionAuthenticationException("您输入额手机号不是系统的注册用户");
        }

        session.removeAttribute(MyContants.CAPTCHA_SESSION_KEY);
    }
}
