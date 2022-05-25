// yd220525/ch02/function2.js

function sum() { // 매개변수 없어도 arguments로 활용 가능!
  let result = 0;
  for (let i = 0; i < arguments.length; i++) {
    result += arguments[i];
  }
  // return n1+n2+n3;
  return result;
}
console.log(`결과: ${sum(10, 20, 30, 40)}`);


// 임의 n개 숫자 더하기
function mySum(a1, a2, ...arg) {
  // a1 값이 없을 경우
  if (a1 == undefined) {
    return 0;
  }

  if (a2 == undefined) {
    return a1;
  }

  let result = 0;
  arg.forEach((val) => {
    result += val;
  });
  return a1 + a2 + result;
}
console.log(`mySum: ${mySum(1, 2, 3, 4, 5, 6, 7)}`);



// ...arg: 펼침연산자
let arr1 = [1, 2, 3];
let arr2 = arr1;
arr2[3] = 4;

let arr3 = [...arr1]; // 주소복사X, 새로운 배열 복사
arr3.push(5);

console.log(arr1, arr3);