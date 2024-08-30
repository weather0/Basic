// yd220527/ch07/dom0.js

// addEventListener: html에서 태그 먼저 다 읽고 함수를 실행하도록
document.addEventListener('DOMContentLoaded', function () {
  let li = document.createElement('li'); // 태그 생성
  let txt = document.createTextNode('Cherry'); // 값 생성 (li.innerText = 'cherry'로 해도 됨)
  li.appendChild(txt);
  // console.log(li);

  // <ul> 자식 li
  let ul = document.querySelector('ul');
  ul.appendChild(li);
  // console.log(ul);



  // 요소를 선택하는 방식
  // element => getElementsBy... : tag
  // node => querySelectorAll() : node(element, attribute, text)
  document.getElementById('friends');
  document.getElementsByClassName('icons');
  document.getElementsByClassName('icons')[0];
  document.getElementsByClassName('animal');
  document.getElementsByClassName('animal')[0];
  document.getElementsByClassName('animal')[0].innerText;
  document.getElementsByClassName('animal')[0].innerText = 'ryon';
  document.getElementsByClassName('animal')[1].innerText = 'frodo';
  document.getElementsByTagName('span')[0].innerHTML;
  document.getElementsByTagName('span')[0].innerHTML = 'small';
  document.getElementsByClassName('icons')[0].children[0].children[0].innerText = '스몰';
  document.querySelector('ul.icons').childNodes[1].childNodes[1].innerText = 'Small';

  // 요소추가
  li = document.createElement('li');
  li.innerText = '김종혁';
  document.querySelector('#newfriends').append(li);

  // 배열활용
  let friends = ['송도언', '소진영', '우영원'];

  let newUl = document.querySelector('#newfriends');
  friends.forEach((friend) => {
    let li = document.createElement('li');

    // mouseover: 마우스가 li태그 범위에 들어서면 이벤트
    li.addEventListener('mouseover', function () { // click, mouseover
      // console.log(this); // this는 li를 의미
      this.style.background = 'yellow';
    });
    // mouseout: 마우스가 li태그 범위를 벗어나면 이벤트
    li.addEventListener('mouseout', function () { // click, mouseover
      // console.log(this);
      this.style.background = '';
    });

    let txt = document.createTextNode(friend);
    li.appendChild(txt); // 그냥 append(txt)해도 됨

    // 버튼생성
    let btn = document.createElement('button');
    btn.innerText = '삭제';
    btn.addEventListener('click', function () {
      this.parentElement.remove(); // this는 button을 의미
    });
    li.append(btn);

    // ul > li
    newUl.append(li);

    // 라이언, 어피치, 프로도 ,콘
    document.querySelectorAll('#friends>li').forEach(li => {
      li.addEventListener('mouseover', function () {
        this.style.background = 'yellow';
      });
      // mouseout: 마우스가 li태그 범위를 벗어나면 이벤트
      li.addEventListener('mouseout', function () {
        this.style.background = '';
      });

    });

  })

});

