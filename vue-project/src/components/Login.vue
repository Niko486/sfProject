<template>
    <div style="width: 100%; height:100vh ;background-color: burlywood;overflow: hidden">
      <div style="width: 400px;margin: 150px auto;margin-left: 380px">
        <el-form
            :model="form"
            label-width="120px"
        >
          <el-form-item label="Username" prop="user">
            <el-input v-model="form.username" type="text" autocomplete="off"/>
          </el-form-item>
          <el-form-item label="Password" prop="pass">
            <el-input v-model="form.password" type="password" autocomplete="off"/>
          </el-form-item>
        </el-form>
        <el-form-item style="margin-left: 40%; margin-top: 10%">
          <el-button type="primary" @click="submitForm(form)">登录</el-button>
          <el-button type="primary" :router="true" >注册</el-button>
        </el-form-item>
      </div>
    </div>

</template>

<script>
import request from "@/assets/js/request";
import router from "@/router";

export default {
  name: "Login",
  data(){
    return {
      form: {
        username: '',
        password: '',
      }
    }
  },
  methods:{
    submitForm(form){
      let url="http://localhost:8081/user/login";
      request.post("http://localhost:8081/user/login",this.form).then(
          res=>{
            console.log(res)
            if (res.status == 200){
              this.$message.success("登录成功")
              this.$router.replace('/page')
            }else {
              this.$message.error(res.data)
            }
          }
      )
    },

  }
}
</script>

<style scoped>

</style>