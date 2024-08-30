// yd220525/ch02/mock_data.js

// mockaroo.com에서 데이터 생성
let data = `[{"id":1,"first_name":"Vince","last_name":"Revill","email":"vrevill0@uiuc.edu","gender":"Female","salary":93},
{"id":2,"first_name":"Galen","last_name":"Lonnon","email":"glonnon1@reverbnation.com","gender":"Male","salary":63},
{"id":3,"first_name":"Zebadiah","last_name":"Bowle","email":"zbowle2@creativecommons.org","gender":"Male","salary":97},
{"id":4,"first_name":"Conrad","last_name":"Cleveley","email":"ccleveley3@altervista.org","gender":"Female","salary":39},
{"id":5,"first_name":"Benoit","last_name":"Fathers","email":"bfathers4@homestead.com","gender":"Male","salary":92},
{"id":6,"first_name":"Kimberlyn","last_name":"Gellert","email":"kgellert5@nature.com","gender":"Agender","salary":92},
{"id":7,"first_name":"Kasper","last_name":"Privost","email":"kprivost6@va.gov","gender":"Male","salary":11},
{"id":8,"first_name":"Wendel","last_name":"Snawdon","email":"wsnawdon7@g.co","gender":"Male","salary":14},
{"id":9,"first_name":"Berty","last_name":"Greenier","email":"bgreenier8@themeforest.net","gender":"Female","salary":35},
{"id":10,"first_name":"Drake","last_name":"Scedall","email":"dscedall9@webnode.com","gender":"Male","salary":54}]`;

data = JSON.parse(data); // JSON => js오브젝트로 변환
console.log(data);

console.clear();

// 급여80이상 필터링
let over80 = data.filter((val, idx) => {
  // console.log(val); // 일단 먼저 확인해보기
  return val.salary >= 80;
});
console.log(over80);

// 여자만 필터링
let females = data.filter(val => val.gender == 'Female');
console.log(females);

// 표만들기(미리 만든 함수 활용)
let str = createTable(females);
document.write(str);