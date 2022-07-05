import myHeader from './components/header.js'
import router from './router/router.js'
import originalData from './data/index.js'
// console.log(indexData.Content)

new Vue({
  el: '#app',
  router, // router: router 의 약식표현
  template:
    `<div>
      <my-header></my-header>
      <router-view></router-view>
    </div>`,
  components: {
    myHeader
  },
  data: {
    userData: [],
    contentData: [],
    commentData: []
  },
  computed: {
    postData: function () {
      return this.contentData.map(content => {
        let selectUserName = this.userData.filter(user => {
          return (user.user_id == content.user_id);
        })[0].name;
        return {
          ...content,
          user_name: selectUserName
        }
      })
    }
  },
  created: function () {
    this.userData = originalData.User;
    this.contentData = originalData.Content;
    this.commentData = originalData.Comment;
  }


})