export default {
  template:
    `<table id="list">
      <tr>
        <th v-for="(val, key) in empHeader">{{key}}
        </th>
      </tr>
      <tr v-for="obj in totalList">
        <td v-for="field in obj">
          {{field}}
        </td>
      </tr>
    </table>`,
  // props: ['totalList', 'empHeader'],
  data: function () {
    return {
      totalList: '',
      empHeader: ''
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