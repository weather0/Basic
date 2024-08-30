import myHeader from './components/myHeader.js'
import router from './router/router.js'
import originalData from './data/index.js'

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
    commentData: [],
    loginUser: {}
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
    // 테스트용 로그인
    this.loginUser = this.userData[0];
  },
  methods: {
    getData: function () {
      return {
        userData: this.userData,
        contentData: this.contentData,
        commentData: this.commentData,
        postData: this.postData
      }
    },
    getLoginInfo: function () {
      return this.loginUser;
    },
    setContentData: function (contentData) {
      this.contentData = contentData;
    },
    setCommentData: function (commentData) {
      this.commentData = commentData;
    }
  }


})