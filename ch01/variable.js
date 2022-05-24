// variable.js
// 전역객체(최상위:window), 전역변수

var avar = '안녕';
let alet = '안녕';


console.log(this); // this는 Window객체를 말함
console.log(this.avar); // var는 Window객체소속임
console.log(this.alet); // let은 아님

function run(){
  console.log(this.avar);
  console.log(this.alet);
}

run();

console.log(aver);
console.log(alet);