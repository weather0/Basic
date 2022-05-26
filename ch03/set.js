// yd220526/ch03/set.js
// set타입: 속성:속성 (키와 밸류가 같다!)

let set = new Set();
set.add("홍길동");
set.add(20);
set.add({});
set.add("홍길동"); // key중복등록X 덮어쓰기 됨(size변동x)
set.add({}); // 근데 오브젝트는 중복등록 됨(size늘어남)
console.log(set.size);

// entry값 반환 → 배열
for (let [key, val] of set.entries()){
  console.log(`key: ${key}, val: ${val}`);
}
// key값만
for (let key of set.keys()) {
  console.log(`key => ${key}`);
};
// value값만(key랑 동일)
for (let value of set.values()) {
  console.log(`value => ${value}`);
};

// let obj1 = {name:"hong"};
// let obj2 = {name:"hong"};
// set.add(obj1);
// set.add(obj2);
// console.log(set.size);