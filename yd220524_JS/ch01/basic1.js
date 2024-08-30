// basic1.js

// [오브젝트1, 오브젝트2, 오브젝트3]

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

const members = [hong, hwang, park];

// 배열확장(배열수 만~큼 반복) for of, 오브젝트확장(필드수 만~큼 반복) for in
for (let member of members) {
  // hong, hwang, park
  for (let field in member) {
    // memberId, memberNm, memberAge
    console.log(field + ': ' + member[field]);
  }
}


// document영역: 스크립트 내 별도 영역(콘솔창X 웹페이지에 결과 표시)
document.write('<h3>Hello</h3>');
document.write('<ul>');
document.write('<li>사과</li>');
document.write('<li>오렌지</li>');
document.write('<li>바나나</li>');
document.write('</ul>');

let table = '<table border=1>';
table += '<tr><th>회원아이디</th><th>회원이름</th><th>회원나이</th></tr>'
for (let member of members) {
  table += '<tr>';
  for(let field in member){
    // ▽for in절을 안쓰고 노가다 한다면?
    // table += '<tr><td>' + member.memberId + '</td><td>' + member.memberNm + '</td><td>' + member.memberAge + '</td></tr>'
    table += '<td>' + member[field] + '</td>';
  }
  table += '</tr>';
}
table += '</table>';

document.write(table);