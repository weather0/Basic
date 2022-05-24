// variable2.js
// 원시형 vs 참조형
// string, number, boolean, undefined vs object(object{}, arry[], function())

let str1 = 'Hello';
let str2 = str1;
console.log(`str1=> ${str1}, str2=> ${str2}`); // str + ', ' + str2
str2 = 'Nice';
console.log(`str1=> ${str1}, str2=> ${str2}`); // str + ', ' + str2

let obj1 = {
  fname: 'Hong'
}
let obj2 = obj1;
console.log(`obj1=> ${obj1.fname}, obj2=> ${obj2.fname}`);
obj2.fname = 'Hwang';
console.log(`obj1=> ${obj1.fname}, obj2=> ${obj2.fname}`);


const obj3 = {
  fname: 'Park'
}

obj3.fname = 'New'; // 필드값을 바꾸는 건 가능

// 새로 참조하는 건 불가능
// obj3 = {
//   fname: 'Newpark'
// }


// 심볼
let sym1 = Symbol('text');
let sym2 = Symbol('text');
console.log(sym1 == sym2); // →false

let hong = {
  sym1: '홍길동'
}