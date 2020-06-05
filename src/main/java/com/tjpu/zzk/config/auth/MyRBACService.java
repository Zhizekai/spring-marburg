package com.tjpu.zzk.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacServicezzk")
public class MyRBACService {


    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Resource
    private MyRBACServiceMapper myRBACServiceMapper;

    /**
     * 判断某用户是否具有该request的访问权限
     * @param request 请求
     * @param authentication 权限
     * @return 是否有权限
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object principal = authentication.getPrincipal();

        //已经登陆了
        if (principal instanceof UserDetails) {
            UserDetails userDetails = ((UserDetails)principal);
            List<GrantedAuthority> authorityList =
                    AuthorityUtils.commaSeparatedStringToAuthorityList(request.getRequestURI());
            return userDetails.getAuthorities().contains(authorityList.get(0));

            //匹配URL
//            return urls.stream().anyMatch(
//                    url -> antPathMatcher.match(url,request.getRequestURI())
//            );
        }

        return false;
    }
}
