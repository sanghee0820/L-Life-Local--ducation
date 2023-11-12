import { createRouter, createWebHistory } from 'vue-router'
import PageOne from '../views/PageOne.vue'
import PageTwo from '../views/PageTwo.vue'
import PageThree from '../views/PageThree.vue'

const routes = [
  {
    path: '/',
    name: 'pageone',
    component: PageOne
  },

  {
    path: '/pagetwo',
    name: 'pagetwo',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: PageTwo
  },

  {
    path: '/pagethree',
    name: 'pagethree',
    component: PageThree
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
