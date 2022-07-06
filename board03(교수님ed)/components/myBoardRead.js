import commentList from './commentList.js'

export default {
  // name: 'my-board-read',
  template:
    `<div>

      <div>
        <!-- 게시글 -->
        <div>
          <span>{{post.content_id}}</span>
          <span>{{post.title}}</span>
          <span>{{post.user_name}}</span>
          <span>{{post.created_at}}</span>
        </div>
        <div>{{post.context}}</div>
      </div>

      <div>
        <!-- 버튼(수정,삭제) -->
        <router-link tag="button" :to="{name:'boardWrite', params:{contentId:post.content_id}}">수정</router-link>
        <button @click="deleteData">삭제</button>
      </div>

      <div>
        <!-- 댓글 -->
        <comment-list :contentId="post.content_id"></comment-list>
      </div>

    </div>`,
  components: {
    // 댓글 기능은 라우터 아닌 부모-자식 컴포넌트 방식으로 구현함
    // 구현 팁: 페이지'전환'은 라우터방식!! 한 페이지 내 지지고볶고는 컴포넌트방식!!
    commentList
  },
  props: ['post'],
  methods: {
    deleteData: function () {
      let contentData = this.$parent.getData().contentData;
      for (let i = 0; i < contentData.length; i++) {
        if (contentData[i].content_id == this.post.content_id) {
          contentData.splice(i, 1);
        }
      }
      this.$parent.setContentData(contentData);

      // 삭제버튼 클릭시 목록으로 리다이렉트
      this.$router.push({ name: 'boardList' })
    }
  }
}