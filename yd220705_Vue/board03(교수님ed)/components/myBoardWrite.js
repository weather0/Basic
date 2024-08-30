export default {
  template:
    `<div>
      <input type="text" v-model="title" placeholder="제목을 입력해주세요">
      <br>
      <textarea v-model="context" placeholder="내용을 입력해주세요" rows="5"></textarea>
      <button @click="updateMode ? updateContent() : uploadContent()">저장</button>
      <router-link tag="button" :to="{name: 'boardList'}">취소</router-link>
    </div>`,
  props: ['contentId'],
  data: function () {
    return {
      // 게시글 등록 시 필요 정보
      title: '',
      context: '',
      user_id: '',
      created_at: '',

      // 게시글 수정 시 필요 정보
      updated_at: '',
      updateObject: '',

      // 모드 전환용 정보
      updateMode: ''
    }
  },
  created: function () {
    if (this.contentId > 0) {
      // 수정모드

      this.contentId = Number(this.contentId) // 숫자타입변환
      // 컴포넌트 출력모드 변경 & 원본데이터 가져옴
      this.updateMode = true;
      this.updateObject = this.$parent.getData().postData.filter(post => {
        return post.content_id == this.contentId
      })[0];
      // 원본 데이터에서 필요한 정보를 렌더링
      this.title = this.updateObject.title;
      this.context = this.updateObject.context;
      // 수정일자를 세팅
      this.updated_at = this.getDate();

    } else {
      // 새글모드
      this.updateMode = false;
      this.user_id = this.$parent.getLoginInfo().user_id;
      this.created_at = this.getDate();
    }
  },
  methods: {
    getDate: function () {
      let today = new Date();

      // 날짜포맷: 공식처럼 외워두자!!
      let year = today.getFullYear();
      let month = ('0' + (today.getMonth() + 1)).slice(-2);
      let day = ('0' + today.getDate()).slice(-2);

      return year + '-' + month + '-' + day;
    },
    uploadContent: function () {
      let contentData = this.$parent.getData().contentData;
      let newContentId = 1;
      if (contentData.length > 0) {
        contentData.sort((a, b) => {
          // 리턴값이 음수(-)면 오름차순, 양수(+)면 내림차순
          return a.content_id - b.content_id
        })
        // 최종 게시글의 글번호에서 1 증가
        newContentId = contentData[contentData.length - 1].content_id + 1
      }

      contentData.push({
        content_id: newContentId,
        user_id: this.user_id,
        title: this.title,
        context: this.context,
        created_at: this.created_at,
        updated_at: this.updated_at
      })

      this.$parent.setContentData(contentData);
      this.$router.push({ name: 'boardList' })

    },
    updateContent: function () {
      let contentData = this.$parent.getData().contentData;
      for (let i = 0; i < contentData.length; i++) {
        if (contentData[i].content_id == this.updateObject.content_id) {
          contentData[i].title = this.title;
          contentData[i].context = this.context;
        }
      }
      this.$parent.setContentData(contentData);
      this.$router.push({ name: 'boardList' })

    }
  }
}