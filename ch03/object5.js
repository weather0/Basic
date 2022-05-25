// yd220525/ch03/object5.js


// let math = new Math();
// math.random();
// 위에처럼 안하고 Math.random();로 바로 호출 가능

for (let i = 0; i < 5; i++) {
  let temp = parseInt(Math.random() * 10) + 1;
  console.log(temp);
}

Math.ceil(3.3); // 올림. 4
Math.floor(3.3); // 3
Math.trunc(3.3); // 3
Math.round(3.5);
console.log(Math.PI);


Math.floor(-3.3); // -3 ~ -4 : -4
Math.trunc(-3.3); // -3


// 클로저: 함수가 실행되는 시점의 변수값을 기억
// 전역변수보다 이렇게 함수안에서 정의하는 걸 추천(보안이점)
function outerFunc(name) {
  let saying = 'hello' + name;

  return function () {
    return saying;
  }
}
let f1 = outerFunc('홍길동');
let f2 = outerFunc('김민수');
console.log(f1());
console.log(f2());


function initFnc(){
  let cnt = 0; 
  return function addCnt(){
    cnt += 1;
    console.log(cnt);
  }
}

let add = initFnc();
add();
add();
add();


