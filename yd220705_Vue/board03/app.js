import myHeader from './components/header.js'
import router from './router.js'
import indexData from './index.js'
// console.log(indexData.Content)

new Vue({
  el: '#app',
  router, // router: router 의 약식표현
  data: {
    indexData // 약식표현
  },
  computed: {
    newArr: function () {
      this.indexData.User.forEach(element => {
        // element.user_id ==
        // <코드작성중>
      });
    }
  },
  template:
    `<div>
      <my-header></my-header>
      <!-- 1.컴포넌트의 props로 값 넘겨주기(직접바인딩할때는 props)
        <my-board-list :object='dataArray'></my-board-list>
      -->
      <router-view></router-view>
    </div>`,
  components: {
    myHeader,
  },
  methods: {
    // 2.컴포넌트의 data로 당겨오도록 게터세터 활용
    getParentData: function () {
      return this.indexData.Content;
    },
    setParentData: function (indexData) {
      this.indexData = indexData.Content;
    }


  }

})