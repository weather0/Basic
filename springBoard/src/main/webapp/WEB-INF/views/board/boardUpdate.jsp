<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <!DOCTYPE html>
      <html>

      <head>
        <meta charset="UTF-8">
        <title>board수정</title>
        <script src="https://code.jquery.com/jquery-3.6.0.js"
          integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
      </head>

      <body>
        <h4>board수정</h4>
        <c:set var="path" value="${pageContext.request.contextPath }" />
        <!-- action="boardInsert"은 지워도 됨. form 기본값이 자기 페이지 -->
        <form action="${pageContext.request.contextPath }/boardUpdate" method="post">
          <!-- ../boardUpdate해도 됨 -->
          <div>글번호
            <input name="bno" value="${board.bno }" readonly="readonly">
          </div>
          <div>제목
            <input name="title" placeholder="제목" value="${board.title }">
          </div>
          <div>내용
            <input name="content" placeholder="내용" value="${board.content }">
          </div>
          <div>작성자
            <input name="writer" placeholder="작성자" value="${board.writer }" readonly="readonly">
          </div>
          <div>등록일
            <input name="regDate" placeholder="등록일" readonly="readonly"
              value='<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd hh:mm" />'>
          </div>
          <button>수정</button>
          <button type="button" id="btnDelete">삭제</button>
        </form>

        <form>
          <input name="" id="">작성자
          <input name="" id="">내용
          <button type="button" id="btnReAdd">댓글등록</button>
        </form>

        <h3>댓글 리스트</h3>
        <div id="replyList">
          <div data-rno="1">
            <span class="reWiter">댓글작성자</span>
            <span class="reContent">댓글내용</span>
            <span class="reDate">작성일시</span>
            <span class="btnReUpd"><button>수정</button></span>
            <span class="btnReDel"><button>삭제</button></span>
          </div>
        </div>



        <script>
          btnDelete.addEventListener("click", function () {
            location.href = "${path}/boardDelete?bno=${board.bno}";
          })

          $.ajax("/mvc/reply/${bno}")
          .done(function(objs){
             for(obj of objs){
            	 let node = `
            	   <div data-rno="\${obj.rno}">
                     <span class="reWiter">"\${obj.replyer}"</span>
                     <span class="reContent">"\${obj.reply}"</span>
                     <span class="reDate">"\${obj.replyDate}"</span>
                     <span class="btnReUpd"><button>수정</button></span>
                     <span class="btnReDel"><button>삭제</button></span>
                   </div>`;
                $("#replyList").append(node);
             }
          })




        </script>
      </body>

      </html>