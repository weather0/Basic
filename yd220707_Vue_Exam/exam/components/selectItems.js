
export default {
  template:
    `<div>
      <ul id="myUL">
        <template v-for="item in items">
          <li v-bind:key="item.no" v-bind:class="{ checked : item.todoyn == 1 }" v-on:click="checkedItem(item, $event)">
            {{ item.contents }}
            <span class="close" v-on:click.stop="deleteItem(item.no)">x</span>
          </li>
        </template>
      </ul>
    </div>`,
  data: function () {
    return {
      items: [],
    }
  },
  // 페이지 진입시 동작
  created: function () {
    // 뷰컴포넌트 지칭하는 this를 변수에 담기(ajax내 this는 ajax를 자신을 지칭)
    let thisCom = this;
    // sql실행(출력)
    $.ajax({
      url: 'http://192.168.0.29/myserver/todoSelect',
      type: 'get',
      data: { id: 20 },
      dataType: 'json',
      success: function (data) {
        console.log(data)
        thisCom.items = data
      },
      error: function (reject) {
        console.log(reject)
        alert('오류')
      }
    })

  },
  methods: {
    // 수정기능
    checkedItem: function (item, event) {
      // checked 클래스 부여
      event.target.classList.toggle('checked');

      // todoyn 변경
      if (item.todoyn == 1) {
        item.todoyn = 0
      } else {
        item.todoyn = 1
      }

      // sql실행(수정)
      $.ajax({
        url: 'http://192.168.0.29/myserver/todoUpdate',
        type: 'get',
        data: { id: 20, no: item.no, todoyn: item.todoyn },
        dataType: 'json',
        success: function (data) {

          alert('수정 성공')

        },
        error: function (reject) {
          console.log(reject)
          alert('오류')
        }
      })
    },

    // 삭제기능
    deleteItem: function (no) {
      // sql실행(삭제)
      $.ajax({
        url: 'http://192.168.0.29/myserver/todoDelete',
        type: 'get',
        data: { id: 20, no: no },
        dataType: 'json',
        success: function (data) {
          alert('삭제 성공')

        },
        error: function (reject) {
          console.log(reject)
          alert('오류')
        }
      })

      // 새로고침
      this.$router.go(0)
    }
  }

}
