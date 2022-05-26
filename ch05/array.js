// yd220526/ch05/array.js

// 인덱스(주소)

let arr = new Array();
arr = [];

// 추가
arr.push('홍길동');
arr.push(20);
arr.push({ name: "hwang", id: "1001" });
arr.push(['사슴', '고양이']);

// 마지막 제거 LIFO
arr.pop();

// 맨 첫 인덱스에 추가
arr.unshift(['사슴', '고양이']);
arr[0] = 'test'; // unshift 무력화됨

// 처음 제거 FIFO
arr.shift;

// 특정위치추가: splice(1:위치, 2:크기, 3:대체값)
arr.splice(1, 1);
arr.splice(1, 0, "add");
arr.splice(1, 0, "add1");
arr.splice(1, 0, "add2");
arr.splice(1, 3);

console.log(arr);


// 교재p.203: reduce() vs forEach()
const arr1 = [1, 2, 3, 4, 5];

let sum1 = arr1.reduce(function (ac, el) {
  return ac + el
}, 0);
console.log(sum1);

let sum2 = 0;
arr1.forEach(function (el) {
  sum2 += el; // sum2 = sum2 + el;
});
console.log(sum2);