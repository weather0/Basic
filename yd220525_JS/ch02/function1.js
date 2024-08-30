// yd220525/ch02/function1.js

// 오브젝트 필드 정의 다른방법 참고 → yd220525/ch03/object1.js, yd220526/ch03/object6.js
const hong = {
  memberId: '001',
  memberNm: '홍길동',
  memberAge: 20
}
const hwang = {
  memberId: '002',
  memberNm: '황우영',
  memberAge: 22
}
const park = {
  memberId: '003',
  memberNm: '박민규',
  memberAge: 25
}
const friends = [hong, hwang, park];

// 테이블생성
// <table><tr><th>타이틀</th></tr><tr><td>데이터</td></tr></table>
function createTable(ary = []) {
  let tag = '<table border=1>';
  tag += createHeader(ary[0]);

  // tr, td 생성
  for (let i = 0; i < ary.length; i++) {
    tag += createTr(ary[i]);
  };
  tag += '</table>';
  return tag;
};

// obj => 속성
// <table><thead>...</thead><tbody>...</tbody></table>
function createHeader(obj = {}) {
  let thead = '<thead><tr>';
  for (let field in obj) {
    thead += `<th>${field}</th>`;
  };
  thead += '</tr></thead>';
  return thead;
};

// Tr
function createTr(obj = {}) {
  // <tr><td>데이터</td></tr>
  let tag = '<tr>';
  for (let field in obj) {
    tag += '<td>' + obj[field] + '</td>';
  };
  tag += '</tr>';
  return tag;
};


let result = createTable(friends);
document.write(result);