package com.tjpu.zzk;

import com.tjpu.zzk.service.MyRBACService;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ZzkApplicationTests {

	private AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Resource
	PasswordEncoder passwordEncoder;

	@Resource
	MyRBACService myRBACService;


	@Test
	public  void contextloads() {
//		System.out.println(passwordEncoder.encode("12345"));

		List<String> urls = new ArrayList();
		urls.add("/biz1");
		urls.add("/biz2");
//		System.out.println(urls);
		boolean rrr  = urls.stream().anyMatch(
				url -> antPathMatcher.match(url, "/biz1")
		);

		System.out.println(rrr);
	}

	@Test
	void contextLoads() {
	}

}
