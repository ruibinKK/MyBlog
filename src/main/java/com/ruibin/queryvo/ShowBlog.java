package com.ruibin.queryvo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ShowBlog {
    private Long id;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean published;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentable;
    private Date updateTime;
}
