package com.mao.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mao.common.dto.LoginDto;
import com.mao.common.lang.Result;
import com.mao.entity.User;
import com.mao.service.UserService;
import com.mao.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.executable.ValidateOnExecution;

@RestController
@Api(tags = "用户管理模块")
public class AccountController {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;
    /**
     * 默认账号密码：胡超 / 10428376
     *
     * 只需要接受账号密码，然后把用户的id生成jwt，
     * 返回给前段，为了后续的jwt的延期，
     * 所以把jwt放在header上
     */

    /**
     * 传过来用户名和密码，放在传过来的body里面，将其转成dto
     * 从 @RequestBody 获取LoginDto
     * @Validated 校验
     * Assert 断言  抛出全局异常IllegalStateException
     * HttpServletResponse response 讲jwt放在Header里面
     * */
    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码错误！");
        }
        //密码正确 jwtUtils.generateToken 生成jwt Token
        String jwt = jwtUtils.generateToken(user.getId());
        //将返回的jwt放在Header里面   传入 HttpServletResponse response
        //Header名称：Authorization
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-Control-Expose-Headers","Authorization");

        //返回用户的一些信息   用户也可以另一个接口
        return Result.succ(MapUtil.builder()    //MapUtil package cn.hutool.core.map
                .put("id",user.getId())
                .put("username",user.getUsername())
                .put("avatar",user.getAvatar())
                .put("email",user.getEmail())
                .map()
        );
    }

    /**
     * 退出
     * */
    @ApiOperation("退出接口")
    @RequiresAuthentication //    @RequiresAuthentication说明需要登录之后才能访问的接口
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
