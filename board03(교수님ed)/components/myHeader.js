// <교수님ed으로 수정요!!!!>

export default {
  name: 'my-header',
  template:
    `<header>
      <h2>
      <!-- 라우터링크에 태그옵션 생략하면 기본이 a태그임(tag="a") -->
      <router-link :to="{name: 'boardList'}">Vue.js 게시판</router-link>
      </h2>
     </header>`

}