import myBoardList from '../components/myBoardList.js'

export default new VueRouter({
  mode: 'history',
  routes: [
    { // boardList 
      path: '/',
      name: 'boardList',
      component: myBoardList,
      props: true
    },

    // { // boardRead
    //   path: '/boardRead/:item',
    //   name: 'boardRead',
    //   component: myBoardRead,
    //   props: true
    // },

    // { // boardWrite
    //   path: '/boardWrite',
    //   name: 'boardWrite',
    //   component: myBoardWrite,
    //   props: true
    // },
    { // 엉뚱한 값이 들어오는 경우 main으로 리다이렉트
      path: '*',
      redirect: '/'
    }
  ]
})