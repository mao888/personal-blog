<template>
  <div id="app">
    <router-view/>
<!--vue是单页面  改变路由刷新的知识路由里的数据-->
<!--路由界面 /Home界面展示到router-view里面-->
  </div>
</template>

<style>
  body{ 
    margin: 0;
  }
  #app{
    /* max-width: 960px; */
    width:100%;
    height:100%;
    padding:0;
    margin:0 auto;
  }
</style>
