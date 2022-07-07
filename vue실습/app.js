import router from './router.js'

new Vue({
  el: '#app',
  router,
  template:
    `<div>
      <!-- 입력/수정/삭제 -->
      <form id="info" onsubmit="return false">
        <label for="id">사원번호</label>
        <input id="id" name="employee_id" type="number" v-model.number="empId">

        <!-- type='submit'만 엔터 먹음(type='button'은 엔터 X) -->
        <router-link tag="button" id="empOne" :to="{name:'empOne', params:{empId:empId}}">조회2</router-link>

        <br>
        <label for="last_name">성</label>
        <input id="last_name" name="last_name" type="text">
        <br>
        <label for="first_name">이름</label>
        <input id="first_name" name="first_name" type="text">
        <br>
        <label for="email">이메일</label>
        <input id="email" name="email" type="email">
        <br>
        <label for="job_id">직책</label>
        <input id="job_id" name="job_id" type="text">
        <br>
        <label for="department_id">부서번호</label>
        <input id="department_id" name="department_id" type="text">
        <br>

        <router-link tag="button" :to="{name:'empList'}">전체조회</router-link>

        <button id="clearform" type="button">지우기</button>
        <button id="submit" type="button">등록</button>
        <button id="updateBtn" type="button">수정</button>
        <button id="deleteBtn" type="button" @click="deleteEmp(empId)">삭제</button>
      </form>

      <router-view></router-view>
    </div>`,
  data: {
    empId: ''
  },
  method: {
    deleteEmp: function (inputId) {
      console.log(inputId)
      fetch('http://192.168.0.29/myserver/empDelete?employee_id=' + inputId)
        .then(alert('삭제 완료'))
        .catch(err => console.log(err))
    }
  }
})