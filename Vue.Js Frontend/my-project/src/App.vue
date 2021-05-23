<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <BookList/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import BookList from './components/BookList.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    BookList
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
