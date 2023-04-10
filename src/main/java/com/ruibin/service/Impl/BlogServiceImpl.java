package com.ruibin.service.Impl;

import com.ruibin.NotFoundException;
import com.ruibin.dao.BlogMapper;
import com.ruibin.pojo.Blog;
import com.ruibin.queryvo.*;
import com.ruibin.service.BlogService;
import com.ruibin.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    @Transactional
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    public List<BlogQuery> getAllBlog() {
        return blogMapper.getAllBlogQuery();
    }

    //删除博客
    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteBlog(id);
    }

    //查询编辑修改的文章
    @Override
    public ShowBlog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    //编辑修改文章
    @Override
    @Transactional
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogMapper.updateBlog(showBlog);
    }

    //搜索博客管理列表
    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogMapper.searchByTitleAndType(searchBlog);
    }

    //查询首页最新博客列表信息
    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogMapper.getFirstPageBlog();
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlogLimt(Integer offset) {
        return blogMapper.getFirstPageBlogLimit(offset);
    }

    //查询首页最新推荐信息
    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        List<RecommendBlog> allRecommendBlog = blogMapper.getAllRecommendBlog();
        return allRecommendBlog;
    }

    //搜索博客列表
    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogMapper.getSearchBlog(query);
    }

    //统计博客总数
    @Override
    public Integer getBlogTotal() {
        return blogMapper.getBlogTotal();
    }

    //统计访问总数
    @Override
    public Integer getBlogViewTotal() {
        return blogMapper.getBlogViewTotal();
    }

    //统计评论总数
    @Override
    public Integer getBlogCommentTotal() {
        return blogMapper.getBlogCommentTotal();
    }

    //统计留言总数
    @Override
    public Integer getBlogMessageTotal() {
        return blogMapper.getBlogMessageTotal();
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        //文章访问数量自增
        blogMapper.updateViews(id);
        //文章评论数量更新
        blogMapper.getCommentCountById(id);
        return detailedBlog;
    }

    //分类页面查询
    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogMapper.getByTypeId(typeId);
    }
}
