<!--（博客详情页）-->
<template>
  <div class="detail">
    <div class="left">
      <slideBar />
    </div>
    <div class="center">
      <Header></Header>
      <div class="mblog">
        <h2>{{ blog.title }}</h2>
        <el-link icon="el-icon-edit" v-if="ownBlog">
          <router-link 
          :to="{ 
            name: 'BlogEdit', 
            params: { blogId: blog.id } 
          }">
            编辑
          </router-link>
        </el-link>
        <el-link icon="el-icon-edit" v-if="ownBlog">
          <el-button type="text" @click="deleteForm()">删除</el-button>
          </el-link>
        <el-divider></el-divider> 
        <div class="content markdown-body" v-html="blog.content"></div>
      </div>
      <!-- <el-autocomplete
        popper-class="my-autocomplete"
        v-model="state"
        :fetch-suggestions="querySearch"
        placeholder="请输入内容"
        @select="handleSelect"
      >
        <i
          class="el-icon-edit el-input__icon"
          slot="suffix"
          @click="handleIconClick"
        >
        </i>
        <template slot-scope="{ item }">
          <div class="name">{{ item.value }}</div>
          <span class="addr">{{ item.address }}</span>
        </template>
      </el-autocomplete> -->
    </div>
    <div class="right">
      <calendor/>
    </div>
  </div>
</template>

<script>
import slideBar from "@/components/slideBar";
import calendor from "@/components/calendor";
import "github-markdown-css/github-markdown.css";
import Header from "@/components/Header";
export default {
  name: "BlogDetail",
  components: { Header, slideBar, calendor },
  data() {
    return {
      blog: {
        userId: null,
        title: "",
        description: "",
        content: "",
      },
      ownBlog: false,
    };
  },
  methods: {
    getBlog() {
      const blogId = this.$route.params.blogId;
      const _this = this;
      this.$axios.get("/blog/" + blogId).then((res) => {
        console.log(res);
        console.log(res.data.data);
        _this.blog = res.data.data;
        var MarkdownIt = require("markdown-it"), //返回的博客详情content通过markdown-it工具进行渲染。
          md = new MarkdownIt();
        var result = md.render(_this.blog.content);
        _this.blog.content = result;
        // 判断是否是自己的文章，能否编辑
        _this.ownBlog = _this.blog.userId === _this.$store.getters.getUser.id;
      });
    },
    deleteForm() {
      const _this = this
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',

          
        }).then(() => {
          this.$axios.delete("?id="+this.$route.params.blogId,{
            headers: {
              "Authorization": localStorage.getItem("token")
            }
          }).then((res)=>{
            this.$message({
            type: 'success',
            message: '删除成功!',})
            
           _this.$router.push("/blogs")
            
          })

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
    
    }
  },
  created() {
    this.getBlog();
  },
};
</script>

<style scoped>
.detail{
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 100%;
  height: 100%;
  /* text-align: left; */
}
.left {
  width:250px;
  height: 1500px;
  position: fixed;
  top:0;
  left:0;
  background:#fdf6ec;
  text-align: center;
}
.center {
  width:80%;
  margin-left:250px;
  background-color: bisque;
  text-align: left;
}
.center .mblog {
  background-color: beige;
  width:80%;
  margin-left:8%;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  min-height: 700px;
  padding: 20px 15px;
}
.right{
  width:20%;
  text-align: center;
  background: #fdf6ec;
}
</style>