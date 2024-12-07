import { generateApi } from 'axios-api-gen';
import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: import.meta.env.VITE_API_PREFIX,
    headers: {
        'Content-Type': 'application/json'
    }
});

const endpoints = {
    getTodos: '/todos',
    postTodo: '/todos',
    putTodo: '/todos/:id',
    deleteTodo: '/todos/:id',

    postLogin: '/users/login',
    postLogout: '/users/logout',
    getUsers: '/users',
    postUsers: '/users',
    putUsers: '/users/:id',
    deleteUsers: '/users/:id'
};

export default generateApi(endpoints, {
    axiosInstance,
    beforeHandler() {
        console.log('before');
        const hasUser = localStorage.getItem('user');
        if (hasUser) {
            const user = JSON.parse(hasUser);
            axiosInstance.defaults.headers.common.Authorization = `Bearer ${user.accessToken}`;
        } else {
            delete axiosInstance.defaults.headers.common.Authorization;
        }
    },
    afterHandler() {
        console.log('after');
    }
});