export default {
  name: 'my-board-list',
  template:
    `<div>
      <table id="list">
        <tr>
          <th>글번호</th>
          <th>글제목</th>
          <th>글쓴이</th>
          <th>작성일</th>
        </tr>
        <tr v-for="post in posts" :key="post.content_id">
          <td>{{post.content_id}}</td>

          <router-link tag="td" :to="{name:'boardRead', params:{post:post}}">
            {{post.title}}</router-link>

          <td>{{post.user_name}}</td>
          <td>{{post.created_at}}</td>
        </tr>
      </table>
      <div>
        <!-- 페이지네이션 -->
      </div>
      <router-link tag="button" :to="{name:'boardWrite'}">
      글쓰기
      </router-link>
    </div>`,
}