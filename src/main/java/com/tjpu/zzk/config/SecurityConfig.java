package com.tjpu.zzk.config;

import com.tjpu.zzk.config.auth.*;
import com.tjpu.zzk.config.auth.imageCode.CaptchaCodeFilter;
import com.tjpu.zzk.config.auth.smscode.SmsCodeSecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * spring Security配置
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled =  true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Resource
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Resource
    MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Resource
    ZzkAuthSuccessHandler zzkAuthSuccessHandler;

    @Resource
    MyUserDetailsService myUserDetailsService;

    @Resource
    private DataSource dataSource; //yml文件里配置的数据源

    @Resource
    private CaptchaCodeFilter captchaCodeFilter;

    @Resource
    private SmsCodeSecurityConfig smsCodeSecurityConfig;
    //源代码
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        http.csrf().disable()//跨站防御攻击
////             .formLogin()
////                .loginPage("/login.html")
////                .usernameParameter("uname")
////                .passwordParameter("pword")
////                .loginProcessingUrl("/login")
////                //.defaultSuccessUrl("/index")
////                //.failureUrl("/login.html")
////                .successHandler(mySuthenticationSuccessHandler)
////                .failureHandler(myAuthenticationFailureHandler)
////             .and()
////             .authorizeRequests()
////                .antMatchers("/login.html","/login").permitAll()
////                .antMatchers("/biz1","/biz2") //需要对外暴露的资源路径
////                    .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
////                //.antMatchers("/syslog","/sysuser")
////                    //.hasAnyRole("admin")  //admin角色可以访问
////                    //.hasAnyAuthority("ROLE_admin")
////                .antMatchers("/syslog").hasAuthority("sys:log")
////                .antMatchers("/sysuser").hasAuthority("sys:user")
////                .anyRequest().authenticated()
////             .and().sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////                .invalidSessionUrl("/login.html")
////                .sessionFixation().migrateSession()
////                .maximumSessions(1)
////                .maxSessionsPreventsLogin(false)
////                .expiredSessionStrategy(new MyExpiredSessionStrategy());
//    }
//


    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http.addFilterBefore(captchaCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable() //禁用跨站csrf攻击防御，后面的章节会专门讲解
                .formLogin()
                .loginPage("/login.html")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                //登录表单form中action的地址，也就是处理认证请求的路径，不用自己实现，前端跳转到这个url，SS自动拦截这个请求
                //并自动做验证
                .loginProcessingUrl("/login")

                .usernameParameter("uname")///登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("pword")//form中密码输入框input的name名，不修改的话默认是password
//                .defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径 和successHandler只能选一个
//                .failureForwardUrl("/login.html")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)

                .and().apply(smsCodeSecurityConfig)

                //记住密码配置
                .and().rememberMe()
                .rememberMeParameter("remember-me-new") //和参数对应
                .rememberMeCookieName("remember-me-cookie") //存在浏览器cookie的名称
                .tokenValiditySeconds(2 * 24 * 60 * 60)
                .tokenRepository(persistentTokenRepository())  //把rememberme令牌 签名都存进数据库

                //权限设置
                .and().authorizeRequests()
                .antMatchers("/login.html","/login","/aftersignout.html","/kaptcha","/smscode","/smslogin").permitAll()//不需要通过登录验证就可以被访问的资源路径
//                .antMatchers("/biz1","/biz2").hasAnyAuthority("ROLE_user","ROLE_admin","ROLE_common")
//                .antMatchers("/sysuser").hasAnyAuthority("/sysuser")
//                .antMatchers("/syslog").hasAnyAuthority("/syslog") //在myUserDetail里面setAuthorities
                //一下路径需要登陆才能访问
                .antMatchers("/index",
                        "/rest/*",//开放restful接口
                        "/swagger-ui.html"
                ).authenticated() //登陆才能看
//                .anyRequest().authenticated()
                .anyRequest().access("@rbacServicezzk.hasPermission(request,authentication)")

                //退出配置
                .and().logout()
                .logoutUrl("/signout")
//                .logoutSuccessUrl("/aftersignout.html") //退出成功跳转到这里
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(myLogoutSuccessHandler)


                //静态加载，需要改成动态加载
                /*.antMatchers("/biz1","/biz2") //需要对外暴露的资源路径
                .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
                .antMatchers("/syslog","/sysuser")
                .hasAnyRole("admin")  //admin角色可以访问
                .antMatchers("/syslog").hasAuthority("/sys_log")  //系统日志，什么样的路径需要什么样的权限
                .antMatchers("/sysuser").hasAuthority("/sys_user")  //系统用户，/sysuser需要/sys_user 权限
                .anyRequest().authenticated()*/

                //session配置
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//其中一种状态
                .invalidSessionUrl("/login.html") //session超时跳转到登陆界面
                .sessionFixation().migrateSession()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredSessionStrategy(new MyExpiredSessionStrategy())
        ;
    }
    /**
     * 用户名和配置
     * @param auth 权限
     * @throws Exception 表达
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                    .withUser("user")
//                    .password(passwordEncoder().encode("123456"))
//                    .roles("user")
//                .and()
//                    .withUser("admin")
//                    .password(passwordEncoder().encode("123456"))
////                    .authorities("sys:log","sys:user")
//                    .roles("admin")
//                .and()
//                    .passwordEncoder(passwordEncoder());//配置BCrypt加密

        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }



    /**
     * 用户名和密码进行加密
     * @return 加密函数
     */
    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//
    /**
     * 静态资源不需要权限
     * @param web web
     */
    @Override
    public void configure(WebSecurity web) {
        //将项目中静态资源路径开放出来
        web.ignoring()
           .antMatchers( "/css/**", "/fonts/**", "/img/**", "/js/**",
                   "/**/*.css",
                   "/**/*.js",
                   "/web","/webjars/**",
                   "/swagger-resources/**",
                   "/v2/**",
                   "/favicon.ico");
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

}
