// yd220526/ch04/practice1.js

let friends = [
  { name: '라이언', age: 5 },
  { name: '어피치', age: 3 },
  { name: '콘', age: 4 },
  { name: '프로도', age: 2 }
];

// map
let newFriends = friends.map(function (val, idx) {
  let obj = {};
  obj.sname = val.name;
  obj.age = val.age * 2;
  obj.sno = idx + 1;

  return obj;
  // return `${obj.sno}, ${obj.sname}, ${obj.age}`;
});
// console.log(newFriends.join('-'));
// let tag = '<li>'+newFriends.join('</li><li>')+'</li>';
// document.write(tag);


let tag = '<table border=1><tr>';
tag += `${newFriends.map(elem => '<td>' + elem.sno + '</td><td>' + elem.sname + '</td><td>' + elem.age + '</td><tr>')}`;
tag += '</tr></table>';
document.write(tag);