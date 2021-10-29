<!--（登录页面）-->
<template>
<!--  template下面只能有一个div-->
<!-- <div> -->
  <el-container>
    <el-header height="380px">
      <!-- width="1500" -->
      <img class="mlogo" src="../assets/mOMo3.png" alt="" >
    </el-header>
    <el-main class="login-main">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
               class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
<!--          双向绑定ruleform==》username  -->
          <el-input type="text" maxlength="12" v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
<!--          双向绑定ruleform==》password  -->
          <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>

<!-- </div> -->
</template>

<script>
export default {
  name: "Login.vue",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        password: '',
        username: ''
      },
      rules: {
        password: [
          {validator: validatePass, trigger: 'blur'}
        ],
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 2, max: 12, message: '长度在 2 到 12 个字符', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {

      // const _this = this  //定义一个全局整个vue项目的this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this  //定义一个全局整个vue项目的this
          // 提交逻辑   .then((res)=>发起请求后的得到的一个结果
          this.$axios.post('http://47.93.20.204:8085/login', this.ruleForm).then((res)=>{
            // this 代表这个请求的this; _this代表全局请求的this
            const token = res.headers['authorization']
            const useInfo=res.data.data

            _this.$store.commit('SET_TOKEN', token)  //jwt token数据存储在localstorage里
            // console.log(res,"111111111111111111")
            _this.$store.commit('SET_USERINFO', useInfo)
            //跳转登录到blogs页面
            _this.$router.push("/blogs")
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.ruleForm.username=null;
      this.ruleForm.password=null;
    }
  },
  mounted() {
    this.$notify({
      title: '看这里：',
      message: '关注CSDN：毛_三月，回复【vueblog】，领取项目资料与源码',
      duration: 1500
    });
  }
}
</script>

<style scoped>
.el-container{
  width:100%;
  height:100%;
}
.el-header, .el-footer {
  height:280px!important;
  color: #333;
  padding:0;
}
.mlogo{
  /* margin-left: 650px; */
  margin: 0 auto;
  padding: 10px;
  display: block;
  text-align:center;
  width:960px;
  height:280px;
}
.el-aside {
  /* background-color: #D3DCE6; */
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  /*background-color: #E9EEF3; Main部分的底色 */
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.demo-ruleForm{
  max-width: 500px;
  margin: auto;
}
.login-main{
  min-height:600px;
}

</style>