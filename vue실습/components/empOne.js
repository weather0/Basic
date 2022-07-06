export default {
  template:
    `<table id="list">
      <tr>
        <th v-for="(val, key) in empHeader">{{key}}
        </th>
      </tr>
      <tr>
        <td v-for="field in empOne">
          {{field}}
        </td>
      </tr>
    </table>`,
  data: function () {
    return {
      empId: this.$parent.getData(),
      empHeader: '',
      empOne: ''
    }
  },
  created: function () {

    // this.empId =  this.$parent.getData()

    fetch('http://192.168.0.29/myserver/empFind?employee_id=', {
      body: empId
    })
      .then(res => res.json())
      .then(data => {
        this.empHeader = data[0]
        this.empOne = data
      })
  }
}