package com.mao.controller;


import com.mao.common.lang.Result;
import com.mao.entity.User;
import com.mao.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Author: @Hu_Chao
 * @since 2021-08-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication     //需要进行一个认证才能进行访问
//    @GetMapping("/index/{id}")
//    public Result test(@PathVariable("id") Long id) {
//        User user = userService.getById(1L);
//        return Result.succ(user);
//    }
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1L);
        return Result.succ(user);
    }

    /**
     * 测试实体校验
     * @param user
     * @return
     */
    /**
     * 使用@Validated注解方式，
     * 如果实体不符合要求，系统会抛出异常，
     * 那么我们的异常处理中就捕获到MethodArgumentNotValidException。
     * */
    @PostMapping("/save")
    public Object testUser(@Validated @RequestBody User user) {
        return user.toString();
    }
}
