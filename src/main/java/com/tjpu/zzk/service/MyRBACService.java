package com.tjpu.zzk.service;

import com.tjpu.zzk.config.auth.MyRBACServiceMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacService")
public class MyRBACService {

    @Resource
    MyRBACServiceMapper myRBACServiceMapper;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断某用户是否具有该request的访问权限
     * @param request 请求
     * @param authentication 被验证用户的主题
     * @return 是否有权限
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object principal = authentication.getPrincipal();
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //被验证用户的主体

        if (principal instanceof UserDetails) {

            String username =  ((UserDetails) principal).getUsername();
            // 根据username 查询用户所拥有权限的所有URL
            List<String> urls = myRBACServiceMapper.findUrlsByUserName(username);
//            System.out.println(request.getRequestURI());
//            System.out.println(urls);

            // 遍历判断用户所访问的请求是否在其权限允许的范围内
            return urls.stream().anyMatch(
                url -> antPathMatcher.match(url, request.getRequestURI())
            );

//            return true;


        }

        return false;
    }

}
