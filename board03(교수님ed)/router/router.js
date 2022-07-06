import myBoardList from '../components/myBoardList.js'
import myBoardRead from '../components/myBoardRead.js'
import myBoardWrite from '../components/myBoardWrite.js'

export default new VueRouter({
  mode: 'history',
  routes: [
    { // boardList 
      path: '/',
      name: 'boardList',
      component: myBoardList,
      // props 안쓰면 라우터 객체에 직접 접근해야 함
    },
    { // boardRead
      path: '/boardRead/:post',
      name: 'boardRead',
      component: myBoardRead,
      props: true // props:true를 씀으로써 path의 get방식으로 데이터를 받을 수 있음
    },

    { // boardWrite
      path: '/boardWrite/:contentId',
      name: 'boardWrite',
      component: myBoardWrite,
      props: true
    },
    { // 엉뚱한 값이 들어오는 경우 main으로 리다이렉트
      path: '*',
      redirect: '/'
    }
  ]
})