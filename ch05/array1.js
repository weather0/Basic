// yd220527/ch05/array1.js
// String.indexOf() => 인덱스 / 없으면 -1 리턴
// Array.indexOf() => 인덱스 / -1
// Array.find(함수) => 찾을 값 / undefined

let arr1 = ['펭수', '라이언', '어피치', '콘', '브라운', '무지'];
let idx = arr1.indexOf('라이언'); // 1
arr1.indexOf('라이언', idx + 1); // 2번위치부터 탐색 → -1(없음)

let find_arr = arr1.find(el => el == '라이언');
console.log(find_arr);

// Array.some(함수) => 1요소라도 조건에 만족하면 true/false
// Array.every(함수) => 모든요소가 조건에 ~ true/false

let true_false = arr1.some(el => el.length >= 3);
console.log(true_false);


// Array.sort();
console.log(arr1.sort().reverse());
let arr2 = [3, 4, 21, 10, 1];
arr2.sort((a, b) => {
  // 방법1
  // a, b => 0보다 큰 값이 반환. b, a
  // a, b => 0보다 작은 값이 반환. a, b
  // if(a - b > 0){
  //   return 10;
  // } else {
  //   return -10;
  // }

  // 방법2
  return a - b; //오름차순
  // return b - a; //내림차순
})
console.log(arr2);

// 오브젝트 정렬
let arr3 = [
  { name: "김민수", age: 25 },
  { name: "최익수", age: 23 },
  { name: "이민기", age: 27 }];

arr3.sort((e1, e2) => e1.age - e2.age);
console.log(arr3);

// 문자열 정렬
let names = "정임경, 박근형, 김진형, 황하경, 류미래";
let arrl = names.split(/,\s+/); // 문자 → split(구분자)로 배열 생성
console.log(arrl.sort()); // 오름차순
console.log(arrl.join(',')); // 배열 → join(구분자)로 문자열 생성