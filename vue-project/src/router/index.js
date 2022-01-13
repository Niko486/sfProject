import {createRouter, createWebHashHistory} from 'vue-router'
import Home from "@/components/Home";
import Login from "@/components/Login";
import Books from "@/components/Books";
import Layout from "@/layout/Layout";
import Register from "@/components/Register";
import Page from "@/components/Page";

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: "/home",
        children: [
            {
                path: '/home',
                name: 'Home',
                component: Home,
            },
            {
                path: '/books',
                name: 'Books',
                component: Books,
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/page',
        name: 'Page',
        component: Page
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
