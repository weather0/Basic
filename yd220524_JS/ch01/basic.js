// basic.js
// 변수의 선언 : var, let

var fname = 'hello'; // String
fname = 100; // number
fname = true; // boolean
fname = null; // '', 0 → null: object
var lname; // undefined

console.log(typeof lname);

console.clear();
var lname = 'Hong';
console.log(lname);

// let lname = 'Hwang'; // let은 중복 선언 불가(에러발생)
// console.log(lname);

{
  let lname = 'Hwang'; // 괄호안에 있으면 괜찮음(지역변수)
  console.log(lname);
}
console.log(lname);
{
  let lname = 'Park'; 
  console.log(lname);
}

const age = 10; // const상수
// age = 20; // 상수는 재정의 불가



// 학생: 이름, 나이, 학생번호. → 오브젝트타입 선언시 {중괄호}
const student = {
  fname: '홍길동',
  age: 20,
  sno: '22-0001',
  info: function(){
    return this.fname + ', ' + this.age;
  }
}
console.log(student.fname); // student의 fname 속성값
console.log(student['age']); // student의 age 속성값
let fieldName = 'sno';
console.log(student[fieldName]); // student의 sno 속성값
console.log(student.info());
// debugger;


// 오브젝트 확장 for .. in
for(let field in student){
  console.log(field + ': ' + student[field]);
}



// 배열
const numAry = [10, 34, 15, 22];
console.log(numAry[0]);
for(let i = 0; i< numAry.length; i++){
  console.log(numAry[i]);
}

// 배열 확장 for..of
for(let num of numAry){
  console.log(num);
}