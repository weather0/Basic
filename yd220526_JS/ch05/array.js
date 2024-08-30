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


let arr2 = [1, 2, [3, 4], [5, 6, 7, [10, 11, { name: "hong", age: 20 }]]];

arr2[2][0]; // 3
console.log(arr2[3][3][2].name); // hong


arr2 = [1, [2, 3], 4, [5, 6, 7]];
let arr_concat = arr2.reduce((stack, el) => {
  // console.log(stack,el);
  return stack.concat(el);
}, []);
console.log(arr_concat);


let arr3 = [1, [2, 3], 4, [5, 6, [7, 8, 9]]];
// 2차원 이상의 배열요소
// join() => 배열을 문자열로 변환
// split(구분자) => 구분자로 새로운 배열을 생성
arr_concat = arr3.reduce((stack, el) => {
  return stack.concat(el);
}, []);
console.log(arr_concat);
console.log(arr_concat.join().split(','));

