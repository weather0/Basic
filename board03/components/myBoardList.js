export default {
  name: 'my-board-list',
  template:
    `<div>
      <table id="list" border="1px">
        <tr>
          <th style="width:50px">글번호</th>
          <th style="width:400px">글제목</th>
          <th style="width:100px">글쓴이</th>
          <th style="width:100px">작성일</th>
        </tr>
        <tr v-for="item in object" :key="item.no">
          <td>{{item.content_id}}</td>

          <router-link tag="td" :to="{name:'boardRead', params:{item:item}}">
            {{item.title}}</router-link>

          <td>{{item.user_id}}</td>
          <td>{{item.created_at}}</td>
        </tr>
      </table>
    </div>`,
  // props: ['object'],
  data: function () {
    return {
      object: []
    }
  },

  // created역할: 객체 내에서 실행할 각종 코드 실행(콘솔로그 확인 등)
  created: function () {
    this.object = this.$parent.getParentData();
  },
  methods: {
    // boardRead: function (info) {
    //   this.$emit('board-read', info)
    // },
    boardDelete: function (no) {
      // this.$emit('board-delete', no)
      for (let i = 0; i < this.object.length; i++) {
        if (this.object[i].no == no) {
          this.object.splice(i, 1);
        }
      }
      this.$parent.setParentData(this.object);
    },
    // boardWrite: function () {
    //   this.$emit('board-write')
    // }
  }


}

