// 부모-자식컴포넌트방식과의 차이(주석처리)에 주목!!!!
export default {
  name: 'my-board-list',
  template:
    `<div>
      <table id="list">
        <tr>
          <th style="width:50px">글번호</th>
          <th>글제목</th>
          <th style="width:50px">조회수</th>
          <th style="width:70px"></th>
        </tr>
        <tr v-for="item in object" :key="item.no">
          <td>{{item.no}}</td>

          <!-- 삭제 <td @click="boardRead(item)">{{item.title}}</td> -->
          <router-link tag="td" :to="{name:'boardRead', params:{item:item}}">
            {{item.title}}</router-link>

          <td>{{item.view}}</td>
          <td><button @click="boardDelete(item.no)">삭제</button></td>
        </tr>
      </table>

      <!-- 삭제 <button style="float:right" @click="boardWrite">글쓰기</button> -->
      <router-link tag="button" style="float:right" :to="{name:'boardWrite'}">글쓰기</router-link>

    </div>`,
  // props: ['object'],
  data: function () {
    return {
      object: []
    }
  },
  created: function () {
    // $parent: 상위
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

