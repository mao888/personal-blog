<!--（博客列表）-->
<template>
  <div class="mcontaner">
    <Header></Header>
    <div class="block">
      <el-timeline>
        <el-timeline-item v-bind:timestamp="blog.created" placement="top" v-for="blog in blogs">
          <el-card>
            <h4><router-link :to="{name: 'BlogDetail', params: {blogId: blog.id}}">{{blog.title}}</router-link></h4>
            <p>{{blog.description}}</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
<!--      带有背景色的分页  设置background属性可以为分页按钮添加背景色。-->
      <el-pagination class="mpage"
          background
          layout="prev, pager, next"
                     :current-page="currentPage"
                     :page-size="pageSize"
                     :total="total"
                      @current-change=page
      >
      </el-pagination>

    </div>


  </div>
</template>

<script>
import Header from "@/components/Header";
export default {
  name: "Blogs.vue",
  components:{Header},
  data(){
    return{     //得到数据
        blogs:[],   //对象
      currentPage:1,    //当前页1 默认第一页
      total:0,    // 一共有多少篇文章
      pageSize:5  //一页5条
    }
  },
  methods:{
    //请求结果进行赋值
    page(currentPage){
      // const _this=this
      this.$axios.get("/blogs?currentPage="+currentPage).then(res=>{
        // console.log(res.data.data.records)
        console.log(res)
        this.blogs = res.data.data.records
        this.currentPage = res.data.data.current
        this.total = res.data.data.total
        this.pageSize = res.data.data.size

      })
    },
  },
  //调用 created方法
  created(){
    this.page(1)
  }
}
</script>

<style scoped>
.mpage{
  margin: 0 auto;
  text-align: center;
}
</style>