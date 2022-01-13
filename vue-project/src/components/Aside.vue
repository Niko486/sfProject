<template>
  <div>
    <el-row class="tac">
      <el-col :span="12">
        <el-menu
            style="width: 200px;min-height: calc(100vh - 50px)"
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            :router="true"
        >
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>用户管理</span>
            </template>
              <el-menu-item index="home">用户列表</el-menu-item>
              <el-menu-item index="1-2">用户管理</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><location /></el-icon>
              <span>图书管理</span>
            </template>
            <el-menu-item index="books">图书分类</el-menu-item>
            <el-menu-item index="1-2">作品审核</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script >
export default {
  name: "Aside"
}
</script>
