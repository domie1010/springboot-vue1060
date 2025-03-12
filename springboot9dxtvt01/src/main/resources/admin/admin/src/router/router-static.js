import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/exampaperlist/exam'
    import examfailrecord from '@/views/modules/examfailrecord/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import examquestion from '@/views/modules/examquestion/list'
    import lianxijilu from '@/views/modules/lianxijilu/list'
    import exampaperlist from '@/views/modules/exampaperlist/list'
    import examquestionbank from '@/views/modules/examquestionbank/list'
    import exampaper from '@/views/modules/exampaper/list'
    import systemnotice from '@/views/modules/systemnotice/list'
    import examrecord from '@/views/modules/examrecord/list'
    import users from '@/views/modules/users/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/examfailrecord',
        name: '错题本',
        component: examfailrecord
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/examquestion',
        name: '题目管理',
        component: examquestion
      }
      ,{
	path: '/lianxijilu',
        name: '练习记录',
        component: lianxijilu
      }
      ,{
	path: '/exampaperlist',
        name: '题库列表',
        component: exampaperlist
      }
      ,{
	path: '/examquestionbank',
        name: '题目库管理',
        component: examquestionbank
      }
      ,{
	path: '/exampaper',
        name: '题库管理',
        component: exampaper
      }
      ,{
	path: '/systemnotice',
        name: '系统公告',
        component: systemnotice
      }
      ,{
	path: '/examrecord',
        name: '答题记录',
        component: examrecord
      }
      ,{
	path: '/users',
        name: '管理员',
        component: users
      }
    ]
  },
  {
    path: '/adminexam',
    name: 'adminexam',
    component: adminexam,
    meta: {icon:'', title:'adminexam'}
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
