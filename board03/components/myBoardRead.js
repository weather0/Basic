// 부모-자식컴포넌트방식과의 차이(주석처리)에 주목!!!!
export default {
  name: 'my-board-read',
  template:
    `<div>
      <table id="list" border="1px">
        <tr>
          <td style="width:50px">글제목</td>
          <td style="width:600px">{{item.title}}</td>
        </tr>
        <tr style="height:300px">
          <td colspan="2">{{item.context}}</td>
        </tr>
      </table>

      <router-link tag="button" style="float:right" :to="{name:'boardList'}">목록</router-link>

    </div>`,
  props: ['item'],
  // methods: {
  //   boardList: function () {
  //     this.$emit('board-list')
  //   }
  // }
}