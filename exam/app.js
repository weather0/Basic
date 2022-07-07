import todoHeader from './components/todoHeader.js'
import router from './router/router.js'

new Vue({
  el: '#app',
  router,
  template:
    `<div>
      <todo-header></todo-header>
      <router-view></router-view>
    </div>`,
  components: {
    'todo-header': todoHeader
  }


})