// store/store.js
import { createStore } from 'vuex';

export default createStore({
    state: {
        gu: '', // 상태 데이터
        course_name: ''
    },
    mutations: {
        setGu(state, newGu) {
            state.gu = newGu; // 상태 변경
        },
        getGu(state) {
            state.gu;
        },
        setCourse(state, newCourse) {
            state.course_name = newCourse;
        },

        getCourse(state) {
            state.course_name;
        },

    },
    actions: {
        // 비동기 작업을 수행하는 액션을 여기에 정의할 수 있습니다.
    },
    getters: {
        // 상태 값을 계산하는 게터를 여기에 정의할 수 있습니다.
    },
});
