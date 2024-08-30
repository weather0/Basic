export default {
  name: 'my-board-write',
  template:
    `<div>
      <table id="list">
        <tr>
          <td>글제목</td>
          <td><input type="text" style="width:90%" v-model="text"></td>
        </tr>
        <tr>
          <td colspan="2">
            <textarea style="width:100%" v-model="content"></textarea>
          </td>
        </tr>
      </table>
      <button style="float:right" @click="boardList">목록</button>
      <button style="float:right" @click="boardSave">저장</button>
    </div>`,
  data: function () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    boardList: function () {
      this.$emit('board-list')
    },
    boardSave: function () {
      this.$emit('board-save', this.title, this.content)
    }
  }
}