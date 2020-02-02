package com.tjpu.zzk.config;

import com.tjpu.zzk.config.auth.MyAuthenticationFailureHandler;
import com.tjpu.zzk.config.auth.MyAuthenticationSuccessHandler;
import com.tjpu.zzk.config.auth.MyExpiredSessionStrategy;
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//             .formLogin()
//                .loginPage("/login.html")
//                .usernameParameter("uname")
//                .passwordParameter("pword")
//                .loginProcessingUrl("/login")
//                //.defaultSuccessUrl("/index")
//                //.failureUrl("/login.html")
//                .successHandler(mySuthenticationSuccessHandler)
//                .failureHandler(myAuthenticationFailureHandler)
//             .and()
//             .authorizeRequests()
//                .antMatchers("/login.html","/login").permitAll()
//                .antMatchers("/biz1","/biz2") //需要对外暴露的资源路径
//                    .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
//                //.antMatchers("/syslog","/sysuser")
//                    //.hasAnyRole("admin")  //admin角色可以访问
//                    //.hasAnyAuthority("ROLE_admin")
//                .antMatchers("/syslog").hasAuthority("sys:log")
//                .antMatchers("/sysuser").hasAuthority("sys:user")
//                .anyRequest().authenticated()
//             .and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .invalidSessionUrl("/login.html")
//                .sessionFixation().migrateSession()
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(false)
//                .expiredSessionStrategy(new MyExpiredSessionStrategy());

//        http.csrf().disable()//跨站防御攻击
//                .formLogin().loginPage("/login.html")//默认在login访问
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/index").and()
//
//                //权限控制
//                .authorizeRequests()
//                .antMatchers("/login.html","login").permitAll()//这两个不需要登陆就能被访问
//                .antMatchers("/biz1","/biz2") //需要对外暴露的资源路径
//                .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
//                .antMatchers("/syslog","/sysuser") //这两个需要admin权限
//                .hasAnyRole("admin")  //admin角色可以访问
//                .anyRequest().authenticated();

        http.csrf().disable().httpBasic()//开启httpbasic认证
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();//所有请求都需要登录认证才能访问
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("user")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder().encode("123456"))
//                .authorities("sys:log","sys:user")
//                .roles("admin")
//                .and()
//                .passwordEncoder(passwordEncoder());//配置BCrypt加密
//    }



//    /**
//     * 用户名和密码进行加密
//     * @return 加密函数
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    /**
//     * 静态资源不需要权限
//     * @param web web
//     */
//    @Override
//    public void configure(WebSecurity web) {
//        //将项目中静态资源路径开放出来
//        web.ignoring()
//           .antMatchers( "/css/**", "/fonts/**", "/img/**", "/js/**");
//    }

}
