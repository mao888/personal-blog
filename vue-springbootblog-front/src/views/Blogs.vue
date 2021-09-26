<!--（博客列表）-->
<template>
  <div class="mcontaner">
    <div class="front">
      <div class="menu">
        <i class="el-icon-s-home" @click="hide()"></i>
        <span>胡超の万事屋</span>
      </div>
    </div>
    <div class="down">
      <div class="left" v-show="isShow">
        <slideBar/>
      </div>
      <div class="center">
        <mainBlogs/>
      </div>
      <div class="right">
        <calendor/>
      </div>
    </div>
  </div>
</template>

<script>
import mainBlogs from "./mainBlog"
import BlogDetail from './BlogDetail'
import slideBar from "@/components/slideBar"
import calendor from '@/components/calendor'
export default {
  name: "Blogs.vue",
  components: {slideBar,calendor,mainBlogs,BlogDetail},
  computed:{
    isShow(){
      return this.$store.getters.getIsShow
    }
  },
  methods: {
    hide(){
      this.$store.commit('changeIsShow',this.isShow)
    },
  },
  // created(){
  //   console.log(this.isShow,"created ----blogs")
  // }
};
</script>

<style scoped>
.mcontaner {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
}
.front{
  width: 100%;
  height:50px;
  line-height:45px;
  background-color:#c6c3c3;
  z-index: 100;
  position: fixed;
}
.front .menu{
  width:200px;
}
.front .menu i{
  width:20px;
  height:20px;
  margin-left:20px;
  color:#fcf2f2;
} 
.front .menu span{
  font-size: 20px;
  font-weight: 600;
  color:#fcf2f2;
  margin-left:8px;
  margin-top: 10px;
}
.down{
  margin-top:50px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
  text-align:center;
}
.left {
  top:50px;
  left:0;
  position: fixed; 
  height:100%;
  width:11%;
  flex-grow:1;
  background:#fdf6ec;
  z-index:10;
}
.center {
  flex-grow:2;
  background-color: #fcf2f2; 
}
.right{
  top: 50px;
  width:35%;
  background: #fdf6ec;
}

</style>