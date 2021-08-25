package com.mao.service.impl;

import com.mao.entity.Blog;
import com.mao.mapper.BlogMapper;
import com.mao.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Author: @Hu_Chao
 * @since 2021-08-19
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
