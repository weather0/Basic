export default {
  // name: 'my-board-list',
  template:
    `<div>

      <table id="list">
        <tr>
          <th>글번호</th>
          <th>글제목</th>
          <th>글쓴이</th>
          <th>작성일</th>
        </tr>
        <tr v-for="post in currentData" :key="post.content_id">
          <td>{{post.content_id}}</td>

          <router-link tag="td" :to="{name:'boardRead', params:{post:post}}">
            {{post.title}}</router-link>

          <td>{{post.user_name}}</td>
          <td>{{post.created_at}}</td>
        </tr>
      </table>

      <!-- 페이지네이션 -->
      <div align="center">
        <button v-for="page in pagingInfo.totalPage" @click="currentPage=page">
          {{page}}
        </button>
      </div>

      <!-- getbootstrap.com 부트스트랩 활용
      <nav aria-label="Page navigation example">
        <ul class="pagination">
          <template v-for="page in pagingInfo.totalPage">
            <li class="page-item"><a class="page-link" href="#" @click="currentPage=page">
              {{page}}
            </li>
          </template>
        </ul>
      </nav>
      -->

      <router-link tag="button" :to="{name:'boardWrite'}">
      글쓰기
      </router-link>

    </div>`,
  data: function () {
    return {
      posts: [],
      currentPage: 1
    }
  },
  computed: {
    // 페이징 관련 totalPage
    pagingInfo: function () {
      let perData = 10;
      // 페이징 상식: 반드시 올림 처리! (반올림X 내림X)
      // Math.ceil(실수)->올림
      let totalPage = Math.ceil(this.posts.length / perData)

      let totalPageArray = [];
      for (let i = 1; i <= totalPage; i++) {
        totalPageArray.push(i)
      }
      return {
        perData: perData,
        totalPage: totalPageArray
      }
    },

    // 현재 페이지에 출력될 데이터
    currentData: function () {
      let firstIndex = (this.currentPage - 1) * this.pagingInfo.perData;
      let lastIndex = firstIndex + this.pagingInfo.perData - 1;

      return this.posts.filter((post, index) => {
        return index >= firstIndex ? (index <= lastIndex ? true : false) : false;
      })

    }
  },
  created: function () {
    this.posts = this.$parent.getData().postData;
  },




}