<!--（博客列表）-->
<template>
  <div class="mcontaner">
      <div class="left">
      <slideBar/>
    </div>
    
    <div class="center">
      <mainBlogs/>
    </div>
    <div class="right">
      <calendor/>
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
  data() {
    return {
     flag:"false"
    }
  },
  methods: {
    
  },

};
</script>

<style scoped>
.mcontaner {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 100%;
  height: 100%;
  text-align:center;
}
.left {
  width:250px;
  height: 1500px;
  position: fixed;
  top:0;
  left:0;
  background:#fdf6ec;
}
element.style {
    padding-left: 20px;
    color: rgb(0, 100, 0);
    background-color: #fafbfc;
}

.center {
  width:80%;
  margin-left:250px;
  /* margin-left:170px;*/
  background-color: #fcf2f2; 
}
.right{
  width:20%;
  background: #fdf6ec;
}

</style>