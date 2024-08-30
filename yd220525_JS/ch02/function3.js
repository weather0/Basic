// yd220525/ch02/function3.js

// 고차함수 => 변수할당. 또는 함수에서 반환되는 함수.
let arr = [];

// 메소드의 매개값으로 함수 사용
arr.forEach(function () {
});

// 함수의 반환값으로 함수도 가능(교재p.72 커링curring 참고)
function addFnc() {
  return function (a, b) {
    return a + b;
  }
}

let fnc = addFnc();
console.log(fnc(10, 20));


// 배열.filter(함수(val,idx,ary){}): 조건에 만족하는 오브젝트를 새로운 배열에 담기
const s1 = {
  sno: '001',
  score: 80
}
const s2 = {
  sno: '002',
  score: 90
}
arr.push(s1);
arr.push(s2);

let newArr = arr.filter(function (val, idx, ary) {
  return val.score >= 90;
});
console.log(newArr);
