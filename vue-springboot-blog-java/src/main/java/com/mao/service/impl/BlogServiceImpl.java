package com.mao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mao.entity.Blog;
import com.mao.mapper.BlogMapper;
import com.mao.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mao.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Author: @Hu_Chao
 * @since 2021-08-19
 */
@Service
@RequiredArgsConstructor
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
//    @Autowired
    private final BlogMapper blogMapper;
//    Autowired
    private final JwtUtils jwtUtils;


    @Override
    public int deleteBlog(Long id) {
        System.out.println(id);
//        LambdaQueryWrapper<Blog> eq = new LambdaQueryWrapper<Blog>().eq(Blog::getId,id);
        int blog=blogMapper.deleteById(id);
        System.out.println("查询结果："+blog);
        return 0;
//        int count = blogMapper.deleteById(id);

//        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
//        wrapper.eq(Blog::getId,id);
//        this.baseMapper.delete(wrapper);
//        int count = blogMapper.deleteById(id);
    }
//    @Override
//    public int deleteBlog(Long blogId) {
//
//        if (jwtUtils.getThreadLocalType() == 0) {
//            return -1;
//        }
//
//        int count = blogMapper.deleteById(blogId);
//
//        //删除博客和标签关系表中的数据
//        QueryWrapper<BlogTagMiddle> wrapper = new QueryWrapper<>();
//        wrapper.eq("blog_id", blogId);
//        blogTagMiddleMapper.delete(wrapper);
//
//
//        //删除该博客的相关评论
//        QueryWrapper<Comment> comWrapper = new QueryWrapper<>();
//        comWrapper.eq("blog_id", blogId);
//        commentMapper.delete(comWrapper);
//
//        return count;
//    }
}
