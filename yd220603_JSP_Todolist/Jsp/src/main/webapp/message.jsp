<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
      #show {
        width: 300px;
        height: 300px;
        border: 1px solid blue;
      }
    </style>
  </head>

  <body>
    <% String user=request.getParameter("user"); %>
      <!--구동시 주소창 user파라미터에서 지정 가능-->
      <div id="show">
        <div class="row">test</div>
      </div>
      <input type="text" name="content">
      <input type="hidden" name="writer" value="<%=user%>">

      <script>
        // insert: 'change' → 엔터를 톡 치면
        document.querySelector('input[name="content"]').addEventListener('change', changeCall);
        function changeCall() {
          let content = document.querySelector('input[name="content"]').value; // 사용자입력값 담기
          let writer = document.querySelector('input[name="writer"]').value;

          fetch('message', {
            method: 'post',
            headers: { 'Content-type': 'application/x-www-form-urlencoded' },
            body: 'writer=' + writer + '&content=' + content
          })
            .then(result => {
              console.log(result);
              e.target.value = '';
            })
            .catch(err => console.log(err));
        }



        // list
        let lastMsg = -1;
        setInterval(e => {
          fetch('message')
            .then(result => result.json())
            .then(resolve => {
              // 기존화면 메시지 지우기
              let divs = document.querySelectorAll('#show div')
              divs.forEach(elem => elem.remove());

              // 14개만 화면에 그려주게끔 필터
              filtAry = resolve.filter(elem => {
                return elem.msgId > lastMsg - 14;
              })

              // 조회된 메시지 새로 그리기
              let show = document.getElementById('show');
              resolve.forEach(row => {
                lastMsg = row.msgId;
                let div = createRow(row);
                show.append(div);
              });
            })
            .catch(error => console.log(error));
        }, 500);

        function createRow(message) {
          let div = document.createElement('div');
          div.setAttribute('class', 'row');
          // JSP파일은 아예 백틱(`) 기능이 안 먹는다!!
          let txt = document.createTextNode(message.writer + ' > ' + message.content);
          div.append(txt);
          // console.log(message.writer);
          // console.log(p.innerText);
          return div;
        }

      </script>
  </body>

  </html>