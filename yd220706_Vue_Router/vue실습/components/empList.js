export default {
  template:
    `<div>
      <table id="list">
        <tr>
          <!-- v-for 객체도 가능 -->
          <th v-for="(val, key) in empHeader">{{key}}
          </th>
        </tr>
        <tr v-for="obj in currentData">
          <td v-for="field in obj">
            {{field}}
          </td>
        </tr>
      </table>
      
      <!-- 페이지네이션 -->
      <div align="center">
        <button v-for="page in pagingInfo.totalPage" @click="currentPage=page">
          {{page}}
        </button>
      </div>
    </div>`,
  // props: ['totalList', 'empHeader'],
  data: function () {
    return {
      totalList: '',
      empHeader: '',
      currentPage: 1
    }
  },
  computed: {
    // 페이징 관련 totalPage
    pagingInfo: function () {
      let perData = 10;
      // 페이징 상식: 반드시 올림 처리! (반올림X 내림X)
      // Math.ceil(실수)->올림
      let totalPage = Math.ceil(this.totalList.length / perData)

      let totalPageArray = [];
      for (let i = 1; i <= totalPage; i++) {
        totalPageArray.push(i)
      }
      return {
        perData: perData,
        totalPage: totalPageArray
      }
    },

    // 현재 페이지에 출력될 데이터
    currentData: function () {
      let firstIndex = (this.currentPage - 1) * this.pagingInfo.perData;
      let lastIndex = firstIndex + this.pagingInfo.perData - 1;

      return this.totalList.filter((obj, index) => {
        return index >= firstIndex ? (index <= lastIndex ? true : false) : false;
      })

    }
  },
  created: function () {
    fetch('http://192.168.0.29/myserver/empSelect')
      .then(res => res.json())
      .then(data => {
        this.empHeader = data[0]
        this.totalList = data
      })
  }











}