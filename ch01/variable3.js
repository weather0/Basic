// variable3.js

let int1 = window.parseInt(3.234); // 소수→정수화
int1 = parseInt('3.14'); // 문자→정수화
int1 = parseInt('hello'); // 자바에서 넘버포맷익셉션
console.log(int1);

let double1 = window.parseFloat('3.14');
double1 = parseFloat('3.15abc'); // 문자에서 실수만 빼와서 출력해줌!(오류 안 남)
console.log(double1);

console.log('3' + '7'); // →37
console.log(parseInt('3') + parseInt('7')); // →10

// number → string
console.log(3);
console.log((3).toString());
let arr = [1, 2, 3];
console.log(arr.toString()); // 구분자 콤마(,)
console.log(arr.join('-')); // 구분자 임의지정(-)


let parentObj = {
  fname: 'window',
  lname: 'close',
  childObj: {
    fname: 'document',
    lname: 'open',
    grandChild: {
      hobby: ['run', 'reading']
    }
  }
}

console.log(parentObj.childObj.grandChild.hobby[0]);