<template>
  <div style="width: 100%;padding: 10px;margin: 10px 0">
    <div style=";padding: 10px">
      <!--搜索区域-->
      <el-input v-model="queryInfo.query" placeholder="请输入关键字" clearable style="width: 30%;"/>
      <el-button style="margin-left: 5px;"  @click="getUser">查询</el-button>
    </div>
    <el-table :data="tableData" stripe border style="width: 100%">
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="username" label="username" sortable/>
      <el-table-column prop="member" label="会员" sortable/>
      <el-table-column prop="points" label="积分" sortable/>
      <el-table-column prop="writer" label="作者" sortable/>
      <el-table-column prop="bookCounts" label="作品 " sortable/>
    </el-table>
    <div style="margin: auto">
      <el-pagination
          v-model:currentPage="queryInfo.currentPage"
          :page-sizes="[5, 10, 20]"
          :page_size=queryInfo.page_size
          layout="sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>

  </div>

</template>

<script>

import request from "@/assets/js/request";

export default {
  name: 'Home',
  components: {},
  data() {
    return {
      total: 0,
      tableData: [],
      queryInfo:{
        query:'',
        page_size: 10,
        currentPage: 1
      },
        // {
        //   id: '',
        //   username: '',
        //   isMember:'',
        //   points:''
        // }

    }
  },
  methods: {
    created() {
      this.load()
    },
    load() {
      request.get("http://localhost:8081/user").then(
          res => {
            console.log(res)
            this.tableData = res.data;
          }
      )
    },
    handleEdit() {

    }
    ,
    handleDelete() {

    },
    getUser() {
      request.get("http://localhost:8081/user/select",{
        params: this.queryInfo
      }).then(
          res => {
            console.log(res)
            this.tableData = res.data;
          }
      )
    },
    handleSizeChange(){

    },
    handleCurrentChange(){

    },
    // async updateStatus() {
    //   const {
    //     data: result
    //   } = {
    //     member: this.tableData.member
    //   }
    //   if (result.status !== 200) return this.$message.error("更新状态失败")
    //   this.$message.success("更新状态成功")
    // }

  },
}

</script>
<style>
</style>
