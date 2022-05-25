// yd220525/ch03/object2.js

// 함수 table 생성
// 클래스로 table 생성

class Table {
  constructor(data) {
    this.tag = '';
    this.aryData = data;
  }

  createHeader() {
    this.tag += '<thead><tr>';
    for (let field in this.aryData[0]) {
      this.tag += `<th>${field}</th>`;
    };
    this.tag += '</tr></thead>';
  }

  createBody() {
    for (let i = 0; i < this.aryData.length; i++) {
      this.tag += '<tr>';
      for (let field in this.aryData[i]) {
        this.tag += '<td>' + this.aryData[i][field] + '</td>';
      };
      this.tag += '</tr>';
    }
  }


  createTable(ary = []) {
    this.tag += '<table border=1>';
    // header정보
    this.createHeader();
    // body정보
    this.createBody();
    this.tag += '</table>';
    return this.tag;
  }
}



let ary = [{
  sno: '1001', 
  sname: '홍길동', 
  score: 80
}, {
  sno: '1002', 
  sname: '김민수', 
  score: 80
}, {
  sno: '1003', 
  sname: '박상민', 
  score: 80
}];
Table.prototype.getTagInfo = function(){
  console.log(this.tag);
}

let table = new Table(ary);
let str = table.createTable(); // <table><thead>타이틀</thead><tbody>데이터</tbody></table>
document.write(str);
table.getTagInfo();

