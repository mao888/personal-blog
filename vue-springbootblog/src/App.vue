<template>
  <div id="app">
<!--    <div id="nav">-->
<!--      <router-link to="/">Home</router-link> |-->
<!--      <router-link to="/about">About</router-link>-->
<!--    </div>-->
    <router-view/>
<!--    vue是单页面  改变路由刷新的知识路由里的数据-->
<!--    路由界面 /Home界面展示到router-view里面-->
  </div>
</template>

<style>
  #app{
    max-width: 960px;
    margin: 0 auto;
  }
</style>
