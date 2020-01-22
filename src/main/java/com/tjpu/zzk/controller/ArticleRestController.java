package com.tjpu.zzk.controller;

import com.tjpu.zzk.model.Article;
import com.tjpu.zzk.model.Reader;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@RestController  //返回json格式
@RequestMapping("/rest")
public class ArticleRestController {

    /**
     * create文章
     * @param article 文章对象
     * @return 已添加的文章
     */
//    @RequestMapping(value = "/article",method = POST,produces = "application/json")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {

        log.info("saveArticle {}",article);
        return AjaxResponse.success(article);
    }

    //表单数据和url传参都能接收
    @PostMapping("/article2")
    public AjaxResponse saveArticle2(@RequestParam Long id ,
                                     @RequestParam String author,
                                     @RequestParam String title,
                                     @RequestParam String content) {
        log.info("saveArticle {}",author);
        return AjaxResponse.success(author);
    }

    /**
     * delete文章
     * @param id 文章ID
     * @return 已删除的文章ID
     */
//    @RequestMapping(value = "/article/{id}",method = DELETE,produces = "application/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle {}",id);
        return AjaxResponse.success(id);
    }

    /**
     * update文章
     * @param id 文章ID
     * @param article 文章对象
     * @return 状态
     */
//    @RequestMapping(value = "/article/{id}",method = PUT,produces = "application/json")
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id ,@RequestBody Article article) {

        article.setId(id);
        log.info("updateArticle {}",article);
        return AjaxResponse.success(id);
    }

    /**
     * retrieve文章
     * @param id 文章ID
     * @return zhuang
     */
//    @RequestMapping(value = "/article",method = POST,produces = "application/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {

        Article article = Article.builder()
                .id(1L).author("zimuge").content("chichichic")
                .createTime(new Date()).title("t1").build();


        return AjaxResponse.success(article);
    }
}
