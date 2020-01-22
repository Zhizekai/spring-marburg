package com.tjpu.zzk.controller;

import com.tjpu.zzk.model.Article;
import lombok.extern.slf4j.Slf4j; //日志
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Article hello() {
        Article article = new Article();

//        article.setAuthor("zimuge");
//        Article article1 = Article.builder().id(5).author("moyan").build();

//        log.info("测试以下"+article1);
        return article;
    }
}
