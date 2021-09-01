package com.mao.service.impl;

import com.mao.entity.User;
import com.mao.mapper.UserMapper;
import com.mao.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
