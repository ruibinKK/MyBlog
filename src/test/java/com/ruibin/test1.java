package com.ruibin;

import com.ruibin.dao.BlogMapper;
import com.ruibin.dao.TypeMapper;
import com.ruibin.dao.UserMapper;
import com.ruibin.pojo.User;
import com.ruibin.queryvo.FirstPageBlog;
import com.ruibin.service.BlogService;
import com.ruibin.utils.MD5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test1 {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private BlogService blogService;
    @Test
    public void testUser(){
        List<FirstPageBlog> allFirstPageBlogLimt = blogService.getAllFirstPageBlogLimt(3);
        for (FirstPageBlog firstPageBlog : allFirstPageBlogLimt) {
            System.out.println(firstPageBlog);
        }
    }
    @Test
    public void testType(){
        System.out.println(typeMapper.getTypeByName("Java"));
    }

}
