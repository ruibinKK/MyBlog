package com.ruibin.controller;

import com.ruibin.queryvo.BlogQuery;
import com.ruibin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){
        List<BlogQuery> blogs = blogService.getAllBlog();
        for (BlogQuery blog : blogs) {
            System.out.println(blog.getCreateTime());
            System.out.println(blog.getFlag());
            System.out.println();
        }
        model.addAttribute("blogs", blogs);
        return "site/archives";
    }
}
