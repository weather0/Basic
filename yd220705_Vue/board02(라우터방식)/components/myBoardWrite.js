// 부모-자식컴포넌트방식과의 차이(주석처리)에 주목!!!!
export default {
  name: 'my-board-write',
  template:
    `<div>
      <table id="list">
        <tr>
          <td>글제목</td>
          <td><input type="text" style="width:90%" v-model="title"></td> <!--v-model주의!-->
        </tr>
        <tr>
          <td colspan="2">
            <textarea style="width:100%" v-model="content"></textarea>
          </td>
        </tr>
      </table>

      <!-- 삭제 <button style="float:right" @click="boardList">목록</button> -->
      <router-link tag="button" :to="{name:'boardList'}">목록</router-link>

      <button style="float:right" @click="boardSave">저장</button>

    </div>`,
  data: function () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    // boardList: function () {
    //   this.$emit('board-list')
    // },
    boardSave: function () {
      let dataArray = this.$parent.getParentData();

      let no = 1;
      if (dataArray.length != 0) {
        let index = dataArray.length - 1;
        no = parseInt(dataArray[index].no) + 1
      }
      let board_info = {
        no: no,
        title: this.title,
        content: this.content,
        view: "1"
      }
      dataArray.push(board_info);

      this.$parent.setParentData(dataArray);

      this.$router.push({ name: 'boardList' })

      // this.writeOk = false;
      // this.readOk = false;
      // this.listOk = true;
    }
  }
}