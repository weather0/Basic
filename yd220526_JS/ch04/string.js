// yd220526/ch04/string.js
// string vs object

let str1 = '홍길동'; // string타입(원시형)
let str2 = new String('홍길동'); // object타입!
console.log(typeof str1, typeof str2);

console.log(str1 == str2); // ==연산자는 값만 비교 → true
console.log(str1 === str2); // ===연산자는 타입까지 비교 → false

// trim: 좌우공백제거
str1 = '   홍  기   동     ';
console.log(str1.trim());

String.prototype.ltrim = function () {
  return this.replace(/^\s+/, '');
}
String.prototype.rtrim = function () {
  return this.replace(/\s+$/, '');
}
console.log(str1.ltrim());
console.log(str1.rtrim());

// split() => 문자열을 매개값을 기준으로 잘라서 배열로 생성
// join(매개값) => 배열타입을 문자로 변경, 매개값을 구분자로 사용
// /\s+/g => 정규표현식: \s(공백)
// +(1개이상). {n}(n개). {n,}(n개이상). 플래그g(전체탐색)
// filter() => 배열에서 매개값 함수의 true값만 새로운 배열

str1 = '   how are  you   to  day everyone.    ';

// split(' ') 공란을 구분자로 짜름(단어만 추출)
console.log(str1.split(' ').filter(elem => elem != '').join(' '));

// console.clear();
// 정규식 활용
console.log(str1.trim().replace(/\s{2,}/g, ' '));
// 공백이 2개이상짜리인 것을 문자열 전체에서 탐색해서 ' '으로 대체하라

// 문자열 찾기: 대상.indexOf(검색어), lastIndexOf()
console.log('hello, world'.indexOf('world'))

// charAt(10);
let strs = 'hello, nice, world, hel'
console.log(strs.substring(strs.indexOf('world') + 'world'.length)); // , hel