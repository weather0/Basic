// 부모-자식컴포넌트방식과의 차이(주석처리)에 주목!!!!
export default {
  name: 'my-board-read',
  template:
    `<div>
      <table id="list">
        <tr>
          <td style="width:50px">글제목</td>
          <td>{{item.title}}</td>
        </tr>
        <tr style="height:300px">
          <td colspan="2">{{item.content}}</td>
        </tr>
      </table>

      <!-- 삭제 <button style="float:right" @click="boardList">목록</button> -->
      <router-link tag="button" style="float:right" :to="{name:'boardList'}">목록</router-link>

    </div>`,
  props: ['item'],
  // methods: {
  //   boardList: function () {
  //     this.$emit('board-list')
  //   }
  // }
}