export default {
  name: 'todo-header',
  template:
    `<div id="myDIV" class="header">
      <h2 style="margin:5px">My To Do List</h2>
      <input type="text" v-model="title" placeholder="Title...">
      <span v-on:click="addItem" class="addBtn">Add</span>
    </div>`,

  data: function () {
    return {
      title: ''
    }
  },
  methods: {
    addItem: function () {
      $.ajax({
        url: 'http://192.168.0.29/myserver/todoInsert',
        type: 'get',
        data: { id: 20, contents: this.title },
        dataType: 'json',
        success: function (data) {
          alert('입력성공')
        },
        error: function (reject) {
          console.log(reject)
          alert('입력오류')
        }
      })
      this.$router.go(0)
    }

  },

}