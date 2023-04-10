package com.ruibin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Blog {
    private Long id;    //id
    private String title;   //标题
    private String content; //内容
    private String firstPicture;    //首图
    private String flag;    //标记
    private Integer views;  //浏览次数
    private boolean appreciation;   //赞赏开启
    private boolean shareStatement; //版权开启
    private boolean commentable;    //评论开启
    private boolean published;  //发布
    private boolean recommend;  //推荐
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间
    private Type type;
//    private List<Tag> tags = new ArrayList<>();
    private User user;
    private List<Comment> comments = new ArrayList<>();

    private String description;
    private Long typeId;
    private Long userId;
    private Integer commentCount;
}
