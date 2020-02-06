package com.tjpu.zzk.service;

import com.tjpu.zzk.model.PersonDemo;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法级权限认证
 */
@Service
public class MethodELService {

    /**
     * 此方法需要admin权限
     * @return null
     */
    @PreAuthorize("hasRole('admin')")
    public List<PersonDemo> findAll(){
        return null;
    }

    @PostAuthorize("returnObject.name == authentication.name")
    public PersonDemo findOne(){
        String authName =
                SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(authName);
        return new PersonDemo("admin");
    }

    /**
     * 当有多个对象是使用filterTarget进行标注
     * 对ids这个参数过滤，过滤规则就是filterObject%2==0，只能传进来偶数
     * @param ids id
     * @param usernames 用户名
     */
    @PreFilter(filterTarget="ids", value="filterObject%2==0")
    public void delete(List<Integer> ids, List<String> usernames) {

    }

    /**
     * 针对返回结果进行过滤
     * 只有被过滤对象对每一个值都和用户的名称相同才能返回
     * @return list
     */
    @PostFilter("filterObject.name == authentication.name")
    public List<PersonDemo> findAllPD(){

        List<PersonDemo> list = new ArrayList<>();
        list.add(new PersonDemo("kobe"));
        list.add(new PersonDemo("admin"));

        return list;
    }
}
