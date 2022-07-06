import main from './components/main.js'
import empList from './components/empList.js'
import empOne from './components/empOne.js'

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      component: main,
      props: true
    },
    {
      path: '/empList',
      name: 'empList',
      component: empList,
      props: true
    },
    {
      path: '/empOne/:empId',
      name: 'empOne',
      component: empOne,
      props: true
    },
    {
      path: '*',
      redirect: '/'
    }
  ]
})