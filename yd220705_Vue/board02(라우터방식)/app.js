// 부모-자식컴포넌트방식과의 차이(주석처리)에 주목!!!!
import myHeader from './components/header.js'
// import myBoardList from './components/myBoardList.js'
// import myBoardRead from './components/myBoardRead.js'
// import myBoardWrite from './components/myBoardWrite.js'
import router from './router.js'

new Vue({
  el: '#app',
  router, // router: router 의 약식표현
  data: {
    // listOk: false,
    // readOk: false,
    // writeOk: false,
    dataArray: [],
    // boardInfo: {}
  },
  template:
    `<div>
      <my-header :parentData.sync='this.$data'></my-header>
      <router-view></router-view>
    </div>`,
  components: {
    myHeader,
    // myBoardList,
    // myBoardRead,
    // myBoardWrite
  },
  methods: {
    /* 
    boardList: function () {
      this.readOk = false;
      this.writeOk = false;
      this.listOk = true;
    },
    boardWrite: function () {
      this.readOk = false;
      this.writeOk = true;
      this.listOk - false;
    },
    boardRead: function (info) {
      this.readOk = true;
      this.writeOk = false;
      this.listOk = false;

      this.boardInfo = info;

      for (let i = 0; i < this.dataArray['board'].length; i++) {
        if (this.dataArray['board'][i].no == info.no) {
          this.dataArray['board'][i].view = parseInt(this.dataArray['board'][i].view) + 1
        }
      }
    }, 
    boardDelete: function (no) {
      for (let i = 0; i < this.dataArray['board'].length; i++) {
        if (this.dataArray['board'][i].no == no) {
          this.dataArray['board'].splice(i, 1)
        }
      }
    }
    */



    // 딱 두가지만 필요함! (게터세터 응용)
    getParentData: function () {
      return this.dataArray['board'];
    },
    setParentData: function (dataArray) {
      this.dataArray['board'] = dataArray;
    }


  }

})