package com.tjpu.zzk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.tjpu.zzk"})  //mapper/Dao自动扫描路径
public class ZzkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZzkApplication.class, args);
	}

}
