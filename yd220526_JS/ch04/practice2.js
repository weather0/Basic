// yd220526/ch04/practice2.js

let str = `Lorem ipsum dolor sit amet ut consectetur adipisicing elit. Quo ut doloremque sed amet quibusdam labore incidunt temporibus tempora neque repellat animi, modi atque facere omnis officiis quidem distinctio rerum vitae.`;
let strAry = str.split(' ');

let findWord = prompt('찾을 문자열 입력하세요>> ');

// startsWith
for (let word of strAry) {
  // console.log(word);
  word.startsWith(findWord);
}

// 특정 문자열로 시작하는 단어만 추출해서 배열에 담기
let newAry = strAry.filter(elem => elem.startsWith(findWord));
console.log(newAry);

// 특정 문자열 포함하는 단어만 추출해서 배열에 담기
let newAry2 = strAry.filter(elem => elem.indexOf(findWord) != -1);
console.log(newAry2);

