package com.ruibin.service;

import com.ruibin.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    //根据博客id查询评论信息
    List<Comment> listCommentByBlogId(Long blogId);

    //添加保存评论
    int saveComment(Comment comment);

    //删除评论
    void deleteComment(Comment comment,Long id);
}
