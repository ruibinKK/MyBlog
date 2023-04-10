package com.ruibin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruibin.NotFoundException;
import com.ruibin.pojo.Type;
import com.ruibin.queryvo.DetailedBlog;
import com.ruibin.queryvo.FirstPageBlog;
import com.ruibin.queryvo.RecommendBlog;
import com.ruibin.service.BlogService;
import com.ruibin.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    //分页查询博客列表
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){
        PageHelper.startPage(pageNum,7);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();
        List<Type> allType = typeService.getAllTypeAndBlog();

//        for (FirstPageBlog firstPageBlog : allFirstPageBlog) {
//            System.out.println(firstPageBlog);
//        }

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        model.addAttribute("typeAll",allType);
        return "index";
    }


    //搜索博客
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 1000);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    //博客信息统计
    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model){
        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
//        int blogMessageTotal = blogService.getBlogMessageTotal();

        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
//        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "_fragements :: blogMessage";
    }

    //跳转博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        model.addAttribute("blog", detailedBlog);


        return "site/blog";
    }

//
//    @GetMapping("/index")
//    public String index(){
//        String blog = null;
//        if(blog==null){
//            throw new NotFoundException("博客不存在");
//        }
//        System.out.println("--------------index------------");
//        return "index";
//    }
//
//    @GetMapping("/blog")
//    public String blog(){
//        return "/site/blog";
//    }
}
