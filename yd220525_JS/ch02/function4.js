// yd220525/ch02/function4.js

var a = 1;
var b = 5;

function outerFunc() {

  function innerFunc() {
    a = b;
  }

  console.log(a);
  a = 3;
  b = 4;
  innerFunc(); // a=b(4)
  console.log(a); // →4
}

outerFunc();