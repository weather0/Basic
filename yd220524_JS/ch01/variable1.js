// variable1.js : 변수의 호이스팅(끌올)

let sum = 10; // 변수선언(값초기화). let은 호이스팅 안 됨
console.log(sum);

console.log(sum2); // 호이스팅: var sum2;(초기값)가 맨 위에 있는 셈 → 출력:undefined
var sum2 = 100;

console.log(myName()); // 호이스팅됨
// object(참조타입변수: 뒤에 () []등 붙여줘야 실제 값이 출력됨) 
// └object, array, funcion(){} 등 
function myName(){
  return '홍길동';
}


var result = 100;
function run(){
  var result = 0;
  console.log(result);
}
run();
console.log(result); // 전역변수는 함수 밖에서도 유효



// function run2(){
//   var result2 = 0;
//   console.log(result2);
// }
// run2();
// console.log(result2); // 지역변수는 함수 밖에서는 무효



{
  let result3 = 100; // 블록단위 변수
}


