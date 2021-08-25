package com.mao.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;
import com.mao.common.lang.Result;
import com.mao.entity.Blog;
import com.mao.service.BlogService;
import com.mao.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Author: @Hu_Chao
 * @since 2021-08-19
 */
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    /**
     * 分页接口
     * Integer currentPage 分页参数
     * @RequestParam(defaultValue = "1") 当没有传值的时候默认为第一页
     * import com.baomidou.mybatisplus.core.metadata.IPage;
     * import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
     * orderByDesc 倒序
     *
     * 没有添加@RequiresAuthentication的接口都可以公开进行访问
     * */
    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
//        if (currentPage==null || currentPage<1) currentPage=1;
        Page page = new Page(currentPage,5);
        IPage pageDate= blogService.page(page,new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.succ(pageDate);
    }

    /**
     * 查询文章接口
     * */
    @GetMapping({"/blog/{id}"})
    public Result detail(@PathVariable(name = "id")Long id){
        Blog blog = blogService.getById(id);
        Assert.notNull(blog,"该博客已删除！");
        return Result.succ(blog);
    }

    /**
     *  编辑和添加是同一体的
     *  @RequiresAuthentication 需要认证权限才能编辑
     * @Validated 校验
     * @RequestBody 从请求体里面获取参数过来
     * @RequestBody Blog blog  如果blog传过来有id则为可编辑；如果没有 则为可添加
     * */
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        System.out.println(blog.toString());
        Blog temp=null;
        //编辑状态
        if (blog.getId()!=null){
            temp=blogService.getById(blog.getId());  //从数据库里查出这篇文章，然后进行更新  赋给temp这个对象
            // 只能编辑自己的文章
            System.out.println(ShiroUtil.getProfile().getId());
            Assert.isTrue(temp.getUserId()== ShiroUtil.getProfile().getId(),"没有编辑权限");
        }else {
            temp=new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        // 将 blog里的title、description、content三个字段赋到新的对象temp里面 进行保存编辑   剩下的忽略
        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);
        return Result.succ(null);
    }

}
