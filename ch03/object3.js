// yd220525/ch03/object3.js

// 인스턴스: 필드, 생성자, 메소드
// 프로토타입: 메소드(함수)의 참조값

let today = new Date(); // 현재시점 년월일 시분초.
console.log(today);
console.log(today.toLocaleString());
console.log(today.toLocaleDateString());
console.log(today.toLocaleTimeString());

// 날짜표시 임의 양식 만들기
Date.prototype.toCustomString = function () {
  // console.log(this);
  let year = this.getFullYear();
  let month = ('0' + (this.getMonth() + 1)).slice(-2); // 0:1월, 1:2월, ... // slice(-n): 뒤에서 n개만 자르기
  let date = this.getDate();
  return `${year}-${month}-${date}`;
}
console.log(today.toCustomString());


// getDay, getDate
today = new Date('2022-11-25'); // 11월 25일
today = new Date(2022, 4, 1); // 5월 1일
today = new Date(2022, 4, 0); // 5월 1일-1(4월30일)
console.log(today.getDay()); // 0:일요일, 1:월요일, ...
console.log(today.getDate());
let day = today.getDay();
let lastDate = today.getDate();



// 달력 만들기
function showCalendar(year, mon) {
  document.write(`<h3>${year}년 ${mon}월 달력</h3>`);
  let caldate = new Date(year, mon - 1, 0); // n월0일 = n-1월말
  let caldate2 = new Date(year, mon, 0); // n+1월0일 = n월말

  document.write('<table border=1><thead><tr>');
  document.write('<th>일요일</th>');
  document.write('<th>월요일</th>');
  document.write('<th>화요일</th>');
  document.write('<th>수요일</th>');
  document.write('<th>목요일</th>');
  document.write('<th>금요일</th>');
  document.write('<th>토요일</th>');
  document.write('</tr></thead><tr>');


  if (caldate.getDay() < 6) { // n-1월말의 요일이 토요일보다 작으면(일~금)
    for (let j = 0; j <= caldate.getDay(); j++) {
      document.write('<td></td>'); // '0 ~ n-1월말요일'개수만큼 빈칸처리
    }
  }

  for (let i = 1; i <= caldate2.getDate(); i++) { // 1부터 n월말까지 찍기
    document.write('<td>' + i + '</td>');
    if (i % 7 == 7 - (caldate.getDay() + 1)) {
      document.write('</tr><tr>');
    }
  }
  document.write('</tr>');
  document.write('</table>');
}

showCalendar(2022, 7); // n월

