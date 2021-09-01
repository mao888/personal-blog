package com.mao.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.mao.entity.User;
import com.mao.service.UserService;
import com.mao.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 将jwtToken传到自定义Realm里面
 * */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    /**
     * supports：为了让realm支持jwt的凭证校验
     * */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    //授权
    /**
     * doGetAuthorizationInfo：权限校验
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证
    /***
     * doGetAuthenticationInfo：登录认证校验
     */
    /**
     * 其实主要就是doGetAuthenticationInfo登录认证这个方法，可
     * 以看到我们通过jwt获取到用户信息，
     * 判断用户的状态，最后异常就抛出对应的异常信息，
     * 否者封装成SimpleAuthenticationInfo返回给shiro。
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();    //getClaimByToken().getSubject() 获取用户id

        User user = userService.getById(Long.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        if (user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
