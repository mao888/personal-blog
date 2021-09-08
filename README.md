> **项目：Vue-SpringBoot-PersonalBlog**
>
> **CSDN：毛_三月**

### 介绍

一个基于**SpringBoot + Vue+MybatisPlus+Shiro+JWT+Redis**开发的前后端分离博客项目，带有超级详细开发文档。还未接触过vue或springboot开发，或者前后端分离 的同学，学起来哈。别忘了给**PersonalBlog**一个**star**！感谢

### vueblog-vue的项目结构

```xml
├── README.md            项目介绍
├── index.html           入口页面
├── build              构建脚本目录
│  ├── build-server.js         运行本地构建服务器，可以访问构建后的页面
│  ├── build.js            生产环境构建脚本
│  ├── dev-client.js          开发服务器热重载脚本，主要用来实现开发阶段的页面自动刷新
│  ├── dev-server.js          运行本地开发服务器
│  ├── utils.js            构建相关工具方法
│  ├── webpack.base.conf.js      wabpack基础配置
│  ├── webpack.dev.conf.js       wabpack开发环境配置
│  └── webpack.prod.conf.js      wabpack生产环境配置
├── config             项目配置
│  ├── dev.env.js           开发环境变量
│  ├── index.js            项目配置文件
│  ├── prod.env.js           生产环境变量
│  └── test.env.js           测试环境变量
├── mock              mock数据目录
│  └── hello.js
├── package.json          npm包配置文件，里面定义了项目的npm脚本，依赖包等信息
├── src               源码目录 
│  ├── main.js             入口js文件
│  ├── app.vue             根组件
│  ├── components           公共组件目录
│  │  └── title.vue
│  ├── assets             资源目录，这里的资源会被wabpack构建
│  │  └── images
│  │    └── logo.png
│  ├── routes             前端路由
│  │  └── index.js
│  ├── store              应用级数据（state）状态管理
│  │  └── index.js
│  └── views              页面目录
│    ├── hello.vue
│    └── notfound.vue
├── static             纯静态资源，不会被wabpack构建。
└── test              测试文件目录（unit&e2e）
  └── unit              单元测试
    ├── index.js            入口脚本
    ├── karma.conf.js          karma配置文件
    └── specs              单测case目录
      └── Hello.spec.js
```



### 技术栈：

![技术栈](https://user-images.githubusercontent.com/59285170/131689992-0dd90ff3-c40e-4477-b3b7-8279988fa110.png)


### 安全框架整合
![shiro整合jwt逻辑分析](https://user-images.githubusercontent.com/59285170/131690082-68c7829f-3407-4074-99aa-8388140aa190.png)


### 项目效果：

#### 登录
![登录界面](https://user-images.githubusercontent.com/59285170/131690119-993b10c8-77d5-4171-bfdc-d1313fd602e2.png)


#### 博客主页
![博客主页](https://user-images.githubusercontent.com/59285170/131690143-5ce54633-4a37-4c0d-9083-f64a50890f28.png)


#### 博客详情页
![博客详情页](https://user-images.githubusercontent.com/59285170/131690180-8b80ab15-556d-4769-8723-14a58e42cd35.png)


#### 发表博客
![发表博客](https://user-images.githubusercontent.com/59285170/131690202-4421b097-8c85-4fd3-a864-4e3c4f369486.png)


### 项目文档：

**项目资源链接**：https://blog.csdn.net/qq_45696377/article/details/120049495 

**Github **：https://mao888.github.io/Personal-blog/

**项目视频讲解**：https://www.bilibili.com/video/BV1VU4y1P7AJ?spm_id_from=333.999.0.0

关注我的Github，后续陆续还会有开源项目

https://github.com/mao888

**更多项目及学习资料请关注CSDN：毛_三月**
![CSDN](https://user-images.githubusercontent.com/59285170/131690379-5b89911a-5f25-4837-8c9f-90039ab86bd4.png)
