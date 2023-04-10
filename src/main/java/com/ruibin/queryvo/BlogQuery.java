package com.ruibin.queryvo;

import com.ruibin.pojo.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

//查询博客列表
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogQuery {
    private Long id;
    private String title;
    private Date updateTime;
    private Date createTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
    private String flag;
}
