<!--（博客详情页）-->
<template>
    <div class="detail">
        <div class="front">
            <div class="menu">
                <i class="el-icon-s-home" @click="hide()"></i>
                <span>胡超の万事屋</span>
            </div>
        </div>
        <div class="down">
            <!-- <div class="left" v-show="isShow">
                <slideBar />
            </div> -->
            <div class="center">
                <div class="blog">
                    <Header></Header>
                    <div class="mblog">
                        <h2>{{ blog.title }}</h2>
                        <el-link icon="el-icon-edit" v-if="ownBlog">
                            <router-link
                                :to="{
                                    name: 'BlogEdit',
                                    params: { blogId: blog.id },
                                }"
                            >
                                编辑
                            </router-link>
                        </el-link>
                        <el-link icon="el-icon-edit" v-if="ownBlog">
                            <el-button type="text" @click="deleteForm()"
                                >删除</el-button
                            >
                        </el-link>
                        <el-divider></el-divider>
                        <div
                            class="content markdown-body"
                            v-html="blog.content"
                        ></div>
                    </div>
                </div>
                <!-- 评论组件 -->
                <Release />
                <Commit />
            </div>
            <div class="right">
                <calendor />
            </div>
        </div>
    </div>
</template>

<script>
import slideBar from "@/components/slideBar";
import calendor from "@/components/calendor";
import "github-markdown-css/github-markdown.css";
import Header from "@/components/Header";
import Commit from "../components/Commit.vue";
import Release from "../components/Release.vue"
export default {
    name: "BlogDetail",
    components: { Header, slideBar, calendor, Commit,Release },
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
    computed: {
        isShow() {
            return this.$store.getters.getIsShow;
        },
    },
    methods: {
        hide() {
            this.$store.commit("changeIsShow", this.isShow);
        },
        getBlog() {
            const blogId = this.$route.params.blogId;
            const _this = this;
            this.$axios.get("/blog/" + blogId).then((res) => {
                // console.log(res);
                // console.log(res.data.data);
                _this.blog = res.data.data;
                var MarkdownIt = require("markdown-it"), //返回的博客详情content通过markdown-it工具进行渲染。
                    md = new MarkdownIt();
                var result = md.render(_this.blog.content);
                _this.blog.content = result;
                // 判断是否是自己的文章，能否编辑
                _this.ownBlog =
                    _this.blog.userId === _this.$store.getters.getUser.id;
            });
        },
        deleteForm() {
            const _this = this;
            this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
            })
                .then(() => {
                    this.$axios
                        .delete("?id=" + this.$route.params.blogId, {
                            headers: {
                                Authorization: localStorage.getItem("token"),
                            },
                        })
                        .then((res) => {
                            this.$message({
                                type: "success",
                                message: "删除成功!",
                            });

                            _this.$router.push("/blogs");
                        });
                })
                .catch(() => {
                    this.$message({
                        type: "info",
                        message: "已取消删除",
                    });
                });
        },
    },
    created() {
        this.getBlog();
    },
};
</script>

<style scoped>
.detail {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
}
.front {
    width: 100%;
    background-color: #c6c3c3;
    z-index: 100;
    position: fixed;
    height: 40px;
    line-height: 40px;
}
.front .menu {
    width: 180px;
}
.front i {
    margin-left: 20px;
    color: #fcf2f2;
}
.front span {
    font-size: 18px;
    font-weight: 600;
    color: #fcf2f2;
    margin-left: 5px;
}
.down {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    width: 100%;
    margin-top: 40px;
}
.down .left {
    top: 40px;
    left: 0;
    position: fixed;
    height: 100%;
    width: 13%;
    flex-grow: 1;
    background: #fdf6ec;
    z-index: 10;
}
.down .center {
    max-width: 80%;
    flex-grow: 2;
    background-color: #fcf2f2;
    padding: 20px;
}
.down .center .mblog {
    background-color: beige;
    /* width:80%;
  margin-left:8%; */
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    min-height: 700px;
    padding: 20px 15px;
}
.down .right {
    width: 20%;
    background: #fdf6ec;
}
</style>