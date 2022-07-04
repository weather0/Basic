import form from './components/form.js'
import main from './components/main.js'
import product from './components/product.js'
import editProduct from './components/editProduct.js'

export default new VueRouter({
  // history모드: 브라우저 히스토리에 접근(뒤로가기 등)
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'iMain',
      component: main,
      props: true // $route.params -> props
    },
    {
      path: '/form',
      name: 'form',
      component: form,
      props: true
    },
    {
      path: '/product/:id',
      name: 'id',
      component: product,
      props: true,
      children: [
        {
          path: 'edit', // -> /product/1/edit (슬래쉬 유무 주의!!)
          name: 'edit',
          component: editProduct,
          props: true
        }
      ]
    },
    {
      path: '*',
      redirect: '/'
    }
  ]

})