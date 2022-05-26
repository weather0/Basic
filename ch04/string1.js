// yd220526/ch04/string1.js
// tagged literal

let str = 'Hello, World';
let message = 'Hi';
str = `${message}`;

let result = `${str == 'Hi' ? true : false}`;
console.log(result);

// 배열요소 : map: A→B / filter:(true)A→A / reduce: map, filter, 집계
let friends = [
  { name: '라이언', age: 5 },
  { name: '어피치', age: 3 },
  { name: '콘', age: 4 },
  { name: '프로도', age: 2 }
];

// 배열.map
let newFriends = friends.map(function (val, idx) {
  let obj = {};
  obj.sname = val.name;
  obj.age = val.age * 2;
  obj.sno = idx + 1;

  return obj;
});
console.log(newFriends);


// 배열.filter
newFriends = friends.filter(function (val, idx) {
  return idx > 1;
});
console.log(newFriends);




// 배열.reduce(함수 (이전값, 현재값, (현재인덱스), (원본배열)) => {return 누적반환값}, 변수초기값)
newFriends = friends.reduce(function (accum, val, idx, ary) {
  return accum + val.age; // 0+5 / 5+3 / 8+4 / 12+2
}, 0); // 0은 초기값 지정
console.log(newFriends);


// 위에 map과 동일한 결과
newFriends = friends.reduce(function (accum, val, idx, ary) {
  let obj = {};
  obj.sname = val.name;
  obj.age = val.age * 2;
  obj.sno = idx + 1;
  accum.push(obj); // []+{} → [{}]+{} → [{},{}]+{} → ...
  return accum;
}, []); // []은 초기값 지정
console.log(newFriends);


// 조건 붙이기
newFriends = friends.reduce(function (accum, val, idx, ary) {
  let obj = {};
  obj.sname = val.name;
  obj.age = val.age * 2;
  obj.sno = idx + 1;
  if (obj.age > 7) {
    accum.push(obj); // []+{} → [{}]+{} → [{},{}]+{} → ...
  }
  return accum;
}, []); // []은 초기값 지정
console.log(newFriends);



// ul li 만들기
newFriends = friends.reduce(function (accum, val, idx, ary) {
  let tag = '';
  if (idx == 0) {
    tag += '<ul>';
  }
  tag += `<li>${val.name}, ${val.age}</li>`;
  if (idx == friends.length - 1) {
    tag += '</ul>';
  }
  return accum + tag;
}, '');
console.log(newFriends);
document.write(newFriends);



// 표 만들기
newFriends = friends.reduce(function (accum, val, idx, ary) {
  let tag = '';
  if (idx == 0) {
    tag += '<table border=1>';
  }
  tag += `<tr><td>${val.name}</td><td>${val.age}</td></tr>`;
  if (idx == friends.length - 1) {
    tag += '</table>';
  }
  return accum + tag;
}, '');
console.log(newFriends);
document.write(newFriends);
