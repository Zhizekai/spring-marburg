package com.tjpu.zzk.controller;

import com.tjpu.zzk.model.AjaxResponse;
import com.tjpu.zzk.model.Article;
import com.tjpu.zzk.service.ArticleRestService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@RestController  //返回json格式
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource
    ArticleRestService articleRestService;


    /**
     * create文章
     * @param article 文章对象
     * @return 已添加的文章
     */

    @ApiOperation(value = "添加文章",notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功",response = AjaxResponse.class),
            @ApiResponse(code = 400,message = "用户输入错误",response = AjaxResponse.class),
            @ApiResponse(code = 500,message = "系统内部错误",response = AjaxResponse.class)



            //dfssdsfdssd
    })
//    @RequestMapping(value = "/article",method = POST,produces = "application/json")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {

        log.info("saveArticle {}",article);

        articleRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    /**
     * 添加文章
     * url传参
     * @param id 文章id
     * @param author 文章作者
     * @param title 文章标题
     * @param content 文章内容
     * @return 状态
     */
    @ApiOperation(value = "添加文章2",notes = "添加新的文章",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功",response = AjaxResponse.class),
            @ApiResponse(code = 400,message = "用户输入错误",response = AjaxResponse.class),
            @ApiResponse(code = 500,message = "系统内部错误",response = AjaxResponse.class)
    })
//    @ApiImplicitParams({
//            //name:参数名 value:参数描述 paramType:参数获取方式query path body dataType:参数数据类型
//            @ApiImplicitParam(name = "title",value = "文章标题",required = true,dataType = "String",paramType = "query"),
//            @ApiImplicitParam(name = "id",value = "文章id",required = true,dataType = "Long",paramType = "query"),
//            @ApiImplicitParam(name = "author",value = "文章作者",required = true,dataType = "String",paramType = "query"),
//            @ApiImplicitParam(name = "content",value = "文章内容",required = true,dataType = "String",paramType = "query")
//    })

    //表单数据和url传参都能接收
    @PostMapping("/article2")
    public AjaxResponse saveArticle2(@RequestParam @ApiParam(value = "文章ID") Long id ,
                                     @RequestParam @ApiParam(value = "文章作者") String author,
                                     @RequestParam @ApiParam(value = "文章标题") String title,
                                     @RequestParam @ApiParam(value = "文章内容") String content) {
        System.out.println(author);
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
