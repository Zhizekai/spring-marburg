package com.tjpu.zzk.config;

import com.tjpu.zzk.config.auth.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * spring Security配置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    MyAuthenticationSuccessHandler mySuthenticationSuccessHandler;

    @Resource
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

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
//
//       http.csrf().disable() //禁用跨站csrf攻击防御，后面的章节会专门讲解
//            .formLogin()
//            .loginPage("/login.html")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
//            .usernameParameter("username")///登录表单form中用户名输入框input的name名，不修改的话默认是username
//            .passwordParameter("password")//form中密码输入框input的name名，不修改的话默认是password
//               .loginProcessingUrl("/login")//登录表单form中action的地址，也就是处理认证请求的路径
//            .defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径
//
//
//        .and()
//            .authorizeRequests()
//            .antMatchers("/login.html","/login").permitAll()//不需要通过登录验证就可以被访问的资源路径
//            .antMatchers("/biz1","/biz2") //需要对外暴露的资源路径
//                .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
//            .antMatchers("/syslog","/sysuser")
//                .hasAnyRole("admin")  //admin角色可以访问
////            .antMatchers("/syslog").hasAuthority("sys:log")
////            .antMatchers("/sysuser").hasAuthority("sys:user")
//            .anyRequest().authenticated();
//    }
//
    @Resource
    ZzkAuthSuccessHandler zzkAuthSuccessHandler;

    @Resource
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http.csrf().disable() //禁用跨站csrf攻击防御，后面的章节会专门讲解
                .formLogin()
                .loginPage("/login.html")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .loginProcessingUrl("/login")//登录表单form中action的地址，也就是处理认证请求的路径
                .usernameParameter("uname")///登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("pword")//form中密码输入框input的name名，不修改的话默认是password

//                .defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径 和successHandler只能选一个
//                .failureForwardUrl("/login.html")

                .successHandler(zzkAuthSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login.html","/login").permitAll()//不需要通过登录验证就可以被访问的资源路径
                .antMatchers("/biz1","/biz2") //需要对外暴露的资源路径
                .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
//                .antMatchers("/syslog","/sysuser")
//                .hasAnyRole("admin")  //admin角色可以访问
                .antMatchers("/syslog").hasAuthority("/sys:log")  //系统日志
                .antMatchers("/sysuser").hasAuthority("/sysuser")  //系统用户
                .anyRequest().authenticated()
        .and()
                //session配置
                .sessionManagement()
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

        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }



    /**
     * 用户名和密码进行加密
     * @return 加密函数
     */
    @Bean
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
           .antMatchers( "/css/**", "/fonts/**", "/img/**", "/js/**");
    }

}
