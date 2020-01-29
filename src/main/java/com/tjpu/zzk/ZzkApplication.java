package com.tjpu.zzk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan(basePackages = {"com.tjpu.zzk.generator"})
public class ZzkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZzkApplication.class, args);
	}

}
