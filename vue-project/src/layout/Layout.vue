<template>
  <div>
    <Manager/>
    <!--  主体-->
    <div style="display:flex;">
      <!--  侧边栏-->
      <Aside/>
      <!--  内荣-->
      <router-view style="flex: 1;"/>
    </div>
  </div>
</template>

<script>
import Manager from "@/components/Manager";
import Aside from "@/components/Aside";
import Home from "@/components/Home";
import Books from "@/components/Books";

export default {
  name: "Layout",
  components: {
    Manager,
    Aside,
    Home,
    Books
  }
}
</script>

<style scoped>

</style>