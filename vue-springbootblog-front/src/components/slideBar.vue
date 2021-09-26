<template>
  <!-- <div class="slideBar"> -->
    <el-menu
        class="el-menu-vertical-demo"
        background-color="#fdf6ec"
        text-color="#006400"
      >
        <el-menu-item index="1">
          <i class="el-icon-ship"></i>
          <a slot="title" href="https://blog.csdn.net/qq_45696377?spm=1000.2115.3001.5343">CSDN</a>
        </el-menu-item>
        <el-menu-item index="2">
          <i class="el-icon-edit"></i>
          <a slot="title" href="https://www.jianshu.com/u/89b7bf8342cb">简书</a>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-goblet-square-full"></i>
          <a slot="title" href="https://creator.douyin.com/creator-micro/home">抖音</a>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-lollipop"></i>
          <a slot="title" href="https://space.bilibili.com/289144374">b站</a>
        </el-menu-item>
        <el-menu-item index="5">
          <i class="el-icon-star-off"></i>
          <a slot="title" href="https://github.com/mao888 ">GitHub</a>
        </el-menu-item>
        <el-menu-item index="6">
          <i class="el-icon-present"></i>
          <a slot="title" href="https://gitee.com/ ">码云</a>
        </el-menu-item>
        <el-menu-item index="7">
          <i class="el-icon-s-promotion"></i>
          <a slot="title" href="https://www.cnblogs.com/humaomao/">博客园</a>
        </el-menu-item>
        <el-menu-item index="8">
          <i class="el-icon-s-comment"></i>
          <a slot="title" href="https://www.zhihu.com/people/yeshent">知乎</a>
        </el-menu-item>
        <el-menu-item index="9">
          <i class="el-icon-s-help"></i>
          <a slot="title" href="https://www.toutiao.com/c/user/token/MS4wLjABAAAAQ_JL56btV-vodA1tVR6yPg-GbxD23cRRlFvK_3KEdt0/?source=feed">今日头条</a>
        </el-menu-item>
    </el-menu>
  <!-- </div> -->
</template>

<script>
export default {
  name:"slideBar",
}
</script>

<style scoped>
a{
  text-decoration:none;
  color: rgb(0 0 0 / 46%);
}
/* /deep/ .el-menu{ */
  /* display: flex;
  flex-direction: column;
  justify-content:space-between; */
/* } */

::v-deep .el-menu{
  height:100%;
  display: block;
}
::v-deep .el-menu-item{
  height:103px;
  line-height: 103px;
  /* height:30%; */
  font-size: 20px;
  text-align:left;
  /* flex: 1; */
    font-size: 24px;
    color: #303133;
    padding: 0px 56px;
    cursor: pointer;
    transition: border-color .3s,background-color .3s,color .3s;
    box-sizing: border-box;
}

/* /deep/ .el-menu-item{
  height:55px;
  /* flex-grow:1; */
  /* font-size: 23px; */
  /* text-align:left; */
  /* justify-content:space-between; */
/* } */ 

/* .el-menu-item, .el-submenu__title {
    height: 60px;
    line-height: 56px;
    position: relative;
    -webkit-box-sizing: border-box;
    white-space: nowrap;
    list-style: none;
} */


</style>