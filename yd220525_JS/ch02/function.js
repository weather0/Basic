// yd220525/ch02/function.js

// ES2015: 매개변수에서 값을 초기화할 수 있음
// 1. 함수선언식 정의
function sum(num1 = 0, num2 = 0) {
  if (num1 == undefined) {
    num1 = 0;
  };
  return num1 + num2;
};
console.log(sum(10, 20));


// 2. 함수표현식 정의
// 변수 = string, number, boolean, undefined, object, function
let mySum = function (val1 = 0, val2 = 0) {
  return val1 + val2;
};

let yourSum = mySum;
console.log(mySum(10, 20));
console.log(yourSum(11, 22));


// 3. 화살표 함수 (코드줄이기): 함수나 매개값으로 사용되어질 때
let otherSum = (val1, val2) => {
  return val1 + val2;
};
// 더 줄이면
let otherSum2 = (val1, val2) => val1 + val2;


// 4. 배열에는 forEach(함수(val, idx, ary){});
const arr = [10, 22, 17, 23, 34, 42];
let arrsum = 0;
arr.forEach(function (val, idx, ary) {
  if (val % 2 == 0) {
    arrsum += val;
  };
});
console.log(`짝수의 합: ${arrsum}`);

// 콜백함수 활용
arrsum = 0;
arr.forEach(getOddSum);
function getOddSum(val, idx, ary) {
  if (val % 2 == 1) {
    arrsum += val;
  };
};
console.log(`홀수의 합: ${arrsum}`);