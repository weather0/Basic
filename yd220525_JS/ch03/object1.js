// yd220525/ch03/object1.js

let obj = {};
// let obj = new Object(); 이렇게 자바식으로 해도 됨(={}랑 동일)
obj.sname = '홍길동';
obj.age = 10;
obj['score'] = 80;
obj.getInfo = function () { // 필드로 함수도 가능
  return `이름은 ${this.sname}, 나이는 ${this.age} 입니다`;
}

console.log(obj.getInfo());

// ES2015
class Student { // 접근제한자는 public이 기본값
  constructor(sno, sname, score) {
    this.sno = sno;
    this.sname = sname;
    this.score = score;
  }

  // 메소드
  // getName() {
  //   return this.sname;
  // }
  // setName(sname) {
  //   this.sname = sname;
  // }
  getInfo() {
    return `이름은 ${this.sname}, 연락처는 ${this.phone} 입니다`;
  }
  setPhone(phone) {
    this.phone = phone;
  }

  // 접근제한을 public이 아닌 숨기기위한 방법: get, set과 언더바를 활용
  // gender라는 속성이 있는 것 처럼 보이지만, 실제로 언더바_gender에 할당되어 사실상 숨김처리 됨
  set gender(gen) {
    this._gender = gen;
  }

  get gender() {
    return this._gender;
  }
}

let s1 = new Student('1001', '홍길동', 80);
s1.setPhone('010-1212-3434');
s1.gender = 'Male';
console.log('성별: ' + s1.gender);

console.log(`학생이름: ${s1.sname}`);
console.log(`학생점수: ${s1.score}`);


let students = [];
// let students = new Array();
students.push(s1);
students.push(new Student('1002', '김민수', 83)); // 배열 요소 추가
students[1].setPhone('010-9876-5432');
console.log(students[1].getInfo());

students.forEach(val => {
  console.log(val.getInfo());
});










// 교재p.100
class Estimate {
  constructor(param) {
    this.unit = param;
  }

  // 견적가 얻기 메소드
  getEstimate(unittype, width, height) {
    let priceInfo = this.unit.find(item => item.type == unittype);
    return priceInfo.price * width * height;
  }

  // 배열에 요소 추가 메소드
  addUnit(unit) {
    unit.push(unit);
  }
}

let unitInfo = [{ type: "wood", price: 100 }, { type: "iron", price: 300 }, { type: "plastic", price: 200 }];
const estimator = new Estimate(unitInfo);
let result = estimator.getEstimate('wood', 20, 20);
console.log(result);