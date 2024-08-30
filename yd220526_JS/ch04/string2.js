// yd220526/ch04/string2.js
// 참고 → yd220525/ch03/object3.js

let today = new Date();

console.log(today);
console.log(today.toISOString());

// 날짜 임의 양식
Date.prototype.customFormat = function () {
  let yyyy = this.getFullYear();
  let mm = this.getMonth() + 1;
  let dd = this.getDate();
  let hh = this.getHours();
  let mi = this.getMinutes();
  let ss = this.getSeconds();

  return `${yyyy}-${('0' + mm).slice(-2)}-${dd} ${hh}:${mi}:${('0' + ss).slice(-2)}`;
}
console.log(today.customFormat());

// 1초마다 찍기
setInterval(function () {
  let today = new Date();
  console.log(today.customFormat());
}, 1 * 1000);