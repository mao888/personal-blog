package com.mao.controller;

import com.mao.entity.User;
import com.mao.service.UserService;
import com.mao.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

//@RestController
//@Api(tags = "注册模块")
//public class SignupController {
//
//    @Autowired
//    JwtUtils jwtUtils;
//    @Autowired
//    UserService userService;
//
//    @ApiOperation("注册接口")
//    @PostMapping("/sign-up")
//    public String upLoad(@RequestParam("file")MultipartFile file, User user){
//        if (file.isEmpty()){
//            return "文件为空";
//        }
//        final String originalFilename = file.getOriginalFilename();
//        final File file1 = new File(new File("src/main/resources/customer/icon").getAbsolutePath() + "/" + originalFilename);
//        if (!file1.getParentFile().exists()){
//            file1.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(file1); //保存文件
//            if ()
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
