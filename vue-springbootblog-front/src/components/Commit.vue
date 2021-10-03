<template>
    <div class="commit-wrap">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <h2>
                    <i class="el-icon-s-order"></i> 
                    评论列表   
                </h2>
            </div>
            <div v-for="m in commit" :key="m.id" class="text item">
                {{m.text}}
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    name: "Commit",
    data(){
        return {
            commit:{},
        }
    },
    mounted(){
        return this.$bus.$on('getCommit',(dataObj)=>{
            this.commit = dataObj;
        });
    }
};
</script>

<style>
.commit-wrap{
    margin-bottom:100px;
}
</style>