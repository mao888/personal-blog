package com.mao.controller;


import com.mao.common.lang.Result;
import com.mao.entity.User;
import com.mao.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;
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
@Api(tags = "测试模块")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication     //需要进行一个认证才能进行访问
//    @GetMapping("/index/{id}")
//    public Result test(@PathVariable("id") Long id) {
//        User user = userService.getById(1L);
//        return Result.succ(user);
//    }
    @ApiOperation("测试接口")
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1L);
        return Result.succ("测试接口成功",user);
    }

    /**
     * 测试实体校验
     * 后端我们可以使用Hibernate validatior来做校验
     * @param user
     * @return
     */
    /**
     * 使用@Validated注解方式，
     * @Validation是一套帮助我们继续对传输的参数进行数据校验的注解，通过配置Validation可以很轻松的完成对数据的约束。
     * @Validated作用在类、方法和参数上
     * 如果实体不符合要求，系统会抛出异常，
     * 那么我们的异常处理中就捕获到MethodArgumentNotValidException。
     * */
    @ApiOperation("测试实体校验接口")
    @PostMapping("/save")
//    @RequestMapping(method = HttpMethod.POST )
    public Object testUser(@Validated @RequestBody User user) {
        return user.toString();
    }
}
