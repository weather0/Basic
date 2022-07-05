// 컴포넌트의 name과 vue객체에서 변수명은 일치해야함!!
// 단, vue에서는 카멜식으로 변환해서 적어야 함. 아니면 오류남!!!!(did you register the component correctly?)
import myHeader from './components/header.js'
import myBoardList from './components/myBoardList.js'
import myBoardRead from './components/myBoardRead.js'
import myBoardWrite from './components/myBoardWrite.js'


new Vue({
  el: '#app',
  data: {
    listOk: false,
    readOk: false,
    writeOk: false,
    dataArray: [],
    boardInfo: {}
  },
  template:
    // 뷰인스턴스의 필드자체(data,watch,computed 등)에 접근 시 달러($)접두! (this.$data)
    `<div>
      <my-header :parentData.sync='this.$data'></my-header>
      <my-board-list v-if="listOk" :object="dataArray['board']" @board-read="boardRead" @board-write="boardWrite"
        @board-delete="boardDelete"></my-board-list>
      <my-board-read v-if="readOk" :object="boardInfo" @board-list="boardList"></my-board-read>
      <my-board-write v-if="writeOk" @board-list="boardList" @board-save="boardSave"></my-board-write>
    </div>`,
  // 1. 뷰 부모-자식컴포넌트방식 구성: 컴포넌트간 의존성 강해짐
  // 2. 라우터 이용: 의존성 해소
  components: {
    // 이건 약식표현임. (정식표현: 'my-header': myHeader)
    myHeader,
    myBoardList,
    myBoardRead,
    myBoardWrite
  },
  methods: {
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
    boardSave: function (title, content) {
      let no = 1;
      if (this.dataArray['board'].length != 0) {
        let index = this.dataArray['board'].length - 1;
        no = parseInt(this.dataArray['board'][this.this.dataArray['board'].length - 1])
      }
      let board_info = {
        no: no,
        title: title,
        content: contecnt,
        view: "1"
      }
      this.dataArray['board'].push(board_info);
      this.writeOk = false;
      this.readOk = false;
      this.listOk = true;
    },
    boardDelete: function (no) {
      for (let i = 0; i < this.dataArray['board'].length; i++) {
        if (this.dataArray['board'][i].no == no) {
          this.dataArray['board'].splice(i, 1)
        }
      }
    }

  }



})
