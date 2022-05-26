// yd220526/ch03/map.js
// map타입: 속성:속성값

let obj = {
  sname: 'Hong',
  age: 10
}

// 1.set으로 담기
let map = new Map();
map.set('sname', 'Hong');
map.set(10, 2);
map.set(obj, 3);
map.set('sname', 'Hwang'); // key중복등록X 덮어쓰기 됨(size변동x)
console.log(map.size);

let val = map.get('sname');
console.log(val);

// entry값 반환 → 배열
for (let [key, val] of map.entries()) {
  console.log(`key => ${key}, val => ${val}`);
};
// key값만
for (let key of map.keys()) {
  console.log(`key => ${key}`);
};
// value값만
for (let value of map.values()) {
  console.log(`value => ${value}`);
};

console.clear();
console.log(map);



// 2.배열로 담기
friends = [["홍길동", 20], ["김민수", 22], ["최민식", 25]];

map = new Map(friends);
for (let [key, val] of map.entries()) {
  console.log(`key => ${key}, val => ${val}`);
};



// map활용
let tag = '<ul>';
for (let [key, val] of map.entries()) {
  // console.log(key, val);
  tag += createList(key, val);
}
tag += '</ul>';
document.write(tag);

function createList(k, v) {
  // console.log(k,v)
  return `<li>${k} - ${v}</li>`;
}