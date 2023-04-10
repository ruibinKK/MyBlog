package com.ruibin.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

//博客详情实体类
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DetailedBlog {
    //博客信息
    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private boolean commentable;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    //分类名称
    private String typeName;
}
