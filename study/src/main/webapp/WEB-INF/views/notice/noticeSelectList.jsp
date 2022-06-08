<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
      <style>
        tr.row:hover {
          background: yellow;
        }
      </style>
    </head>

    <body>
      <div align="center">
        <div>
          <h1>공지사항 목록</h1>
        </div>
        <div>
          <table border="1">
            <thead>
              <tr>
                <th width="100">글번호</th>
                <th width="150">작성자</th>
                <th width="250">제목</th>
                <th width="150">작성일자</th>
                <th width="100">조회수</th>
            </thead>

            <tbody>
              <c:forEach items="${notices }" var="notice">
                <%-- ${notices }는 서버에서 request에 담은 변수 --%>
                  <tr class="row" onclick="noticeSelect(${notice.id})">
                    <td align="center">${notice.id }</td>
                    <%-- var="notice" → ${notice.vo} --%>
                      <td align="center">${notice.writer }</td>
                      <td>${notice.title }</td>
                      <td align="center">${notice.wdate }</td>
                      <td align="center">${notice.hit }</td>
                  </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <br />
        <div>
          <%--상식: id는 js에서, name은 자바에서 사용하는 변수--%>
            <form id="frm" action="noticeSelect.do" method="post">
              <input type="hidden" id="id" name="id">
            </form>
        </div>
        <div>
          <button type="button" onclick="location.href='home.do'">홈가기</button>
        </div>
      </div>
      <script type="text/javascript">
        function noticeSelect(id) {
          // location.href = "noticeSelect.do?id=" + id; // GET방식
          frm.id.value = id; // POST방식: hidden을 이용. id를 넣고
          frm.submit(); // 폼자체를 submit함(정보은닉)

        }
      </script>

    </body>

    </html>