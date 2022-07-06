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

  // vue의 프로퍼티 유형 3개: data(=원본값), computed(=수정값), watch(=일련의동작)
  // computed: data속성을 필요에 따라 산출해서 또 다른 프로퍼티 -> 읽기 전용
  // watch: 프로퍼티 변화를 감지해서 진행해야 하는 프로세스 정의

  // created: 뷰객체 라이프사이클 중 어느 시점 실행할 각종 프로세스 정의(콘솔로그 확인 등)
  // created는 시점이다! Vue객체 생성 시점! 데이터유무나 변화와는 상관 없음!!
  // 위의 프로퍼티유형들과 created 혼동 주의!!(전혀 다른 개념)
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

