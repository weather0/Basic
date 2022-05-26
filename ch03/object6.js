// yd220526/ch03/object6.js
// 오브젝트: 속성=속성값, 속성=함수
const friends = ['김민식', '황성우',]

// 필드추가방법1
let obj = {
  sname: '홍길동',
  age: 20,
  getInfo: function () { return this.sname; }
}

// 방법2
obj.phone = '010-1111-2222';
obj.friends = friends;

// 방법3: 위 방법들과 다르게 제약 설정 가능
Object.defineProperty(obj, 'score', {
  set: function (score) {
    if (score < 0) {
      alert('나이가 0보다 작습니다.')
    } else if (score >= 100) {
      alert('나이가 100보다 작습니다.')
    } else {
      this._score = score;
    }
  },
  get: function () {
    return this._score;
  }
});
// obj.score = -10; // 제약에 걸림
obj._score = -10; // 변수자체는 당연히 아무 값 설정됨

console.log(obj);

// 객체의 복사
let refObj = obj;

let copyObj = Object.assign({}, obj);
copyObj.age = 30; // 원본 obj는 변동X

console.log(copyObj, obj);