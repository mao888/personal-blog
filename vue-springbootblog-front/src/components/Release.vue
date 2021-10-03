<template>
    <div>
        <el-card class="box-card">
            <div slot="header" :class="classHeader" class="clearfix">
                <h2>
                    <i class="el-icon-s-promotion"></i>
                    发表评论
                </h2>
                <!-- 请补充服务器地址 -->
                <form action="#">
                    <el-input
                        type="textarea"
                        :rows="2"
                        placeholder="请留下精彩的评论！"
                        v-model="commit"
                    >
                    </el-input>
                    <el-button
                        :class="classBtn"
                        style="float: right; padding: 3px 0"
                        type="submit"
                        @click="release"
                        >发布评论</el-button
                    >
                </form>
            </div>
        </el-card>
    </div>
</template>

<script>
import axios from "axios";
export default {
    name: "Release",
    data() {
        return {
            commit: "",
            classBtn: {
                btn: true,
            },
            classHeader: {
                header: true,
            },
        };
    },
    methods: {
        release() {
            // 初始化评论信息
            this.$bus.emit("getCommit", {});
            // 发送ajsx请求（自行补充接口）
            axios.get(``).then(
                (response) => {
                    console.log("请求成功！");
                    this.$bus.emit("getCommit", {
                        id: response.id,
                        text: response.text,
                    });
                },
                (error) => {
                    console.log("请求失败！", error.data);
                    this.$bus.emit("getCommit", {});
                }
            );
        },
    },
};
</script>

<style scoped>
.textarea {
    margin-bottom: 10px;
}
.btn {
    width: 100px;
    height: 30px;
    background-color: rgb(247, 240, 240);
    margin: 10px;
}
.header {
    padding-bottom: 20px;
}
</style>