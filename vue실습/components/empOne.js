export default {
  template:
    `<table id="list">
      <tr>
        <th v-for="(val, key) in empOne">{{key}}
        </th>
      </tr>
      <tr>
        <td v-for="field in empOne">
          {{field}}
        </td>
      </tr>
    </table>`,
  props: ['empId'],
  data: function () {
    return {
      empOne: ''
    }
  },
  created: function () {
    console.log(this.empId)
    // create에 직접 페치하면 1회만 실행돼서 걍 메소드로 뺌
    this.empOneFn();
    $('#empOne').click(this.empOneFn)
  },
  methods: {
    empOneFn: function () {
      fetch('http://192.168.0.29/myserver/empFind?employee_id=' + this.empId)
        .then(res => res.json())
        .then(data => {
          this.empOne = data;
          for (let field in data) {
            $('#' + field).val(data[field]);
            $('#submit').css('display', 'none');
            $('#updateBtn').css('display', 'inline-block');
            $('#deleteBtn').css('display', 'inline-block');
          }
        })
        .catch(err => alert('해당 임직원 없음'))
    }

  }
}