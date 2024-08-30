import main from './components/main.js'
import myBoardList from './components/myBoardList.js'
import myBoardRead from './components/myBoardRead.js'
import myBoardWrite from './components/myBoardWrite.js'

export default new VueRouter({
  mode: 'history',
  routes: [
    { // main
      path: '/',
      name: 'main',
      component: main,
      props: true
    },

    { // boardList 
      path: '/boardList',
      name: 'boardList',
      component: myBoardList,
      props: true
    },

    { // boardRead
      path: '/boardRead/:item',
      name: 'boardRead',
      component: myBoardRead,
      props: true
    },

    { // boardWrite
      path: '/boardWrite',
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