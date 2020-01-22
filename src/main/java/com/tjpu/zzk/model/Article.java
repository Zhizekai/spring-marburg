package com.tjpu.zzk.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data //getter setter
@AllArgsConstructor //全参构造方法
@NoArgsConstructor  //无参构造方法
@Builder
public class Article {


    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */

//    @JsonIgnore //忽略序列化
    private long id;

//    @JsonAlias("author22")  //其别名
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;



}
