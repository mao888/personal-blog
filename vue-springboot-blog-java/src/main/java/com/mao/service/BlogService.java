package com.mao.service;

import com.mao.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Author: @Hu_Chao
 * @since 2021-08-19
 */
public interface BlogService extends IService<Blog> {

    /**
     * description: 删除博客
     *
     * @param id 博客id
     * @return
     * @author HuChao
     * Date: 2021/8/28  21:26
     */
    @Transactional(rollbackFor = Exception.class)
    int deleteBlog(Long id);
}
