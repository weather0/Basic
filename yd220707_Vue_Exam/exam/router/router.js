import selectItems from '../components/selectItems.js'

export default new VueRouter({
  // mode: 'history',
  routes: [
    {
      path: '/',
      name: 'selectItems',
      component: selectItems,
      props: true
    },
    {
      path: '*',
      redirect: '/'
    }
  ]
})