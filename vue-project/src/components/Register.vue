<template>
  <div style="width: 100%; height:100vh;">
    <div style="width: 400px;margin: 150px auto;margin-left: 380px">
      <el-form
          :model="form"
          label-width="120px"
      >
        <el-form-item label="用户名" prop="user">
          <el-input v-model="form.username" type="text" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input v-model="form.password" type="password" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="确认密码" prop="pass">
          <el-input v-model="is_password" type="password" autocomplete="off"/>
        </el-form-item>
      </el-form>
      <el-form-item style="margin-left: 56%; margin-top: 10%">
        <el-button type="primary" @click="register(form)"
        >注册
        </el-button>
      </el-form-item>
    </div>
  </div>
</template>

<script>
import request from "@/assets/js/request";

export default {
  name: "Register",
  data() {
    return {
      form: {
        username: '',
        password: '',
      },
      is_password:''
    }
  },
  methods: {
    register(form) {
      request.put("http://localhost:8081/user/register", this.form).then(
          res => {
            if (res.status == 200){
              this.$message.success("注册成功")
            }else {
              this.$message.error("注册失败")
            }
          }
      )
    }
  }
}
</script>

<style scoped>

</style>