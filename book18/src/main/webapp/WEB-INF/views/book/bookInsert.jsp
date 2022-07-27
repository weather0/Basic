<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book등록</title>
</head>
<body>
  <h4>도서등록</h4>
  <form action="bookInsert" method="post" name="myForm">
    <table>
      <tr>
        <td>도서번호</td>
        <td><input name="bookNo" placeholder="도서번호" readonly="readonly" value="${books.bookNo }"></td>
      </tr>
      <tr>
        <td>도서명</td>
        <td><input name="bookName" placeholder="도서명" class="bookName"></td>
      </tr>
      <tr>
        <td>도서표지</td>
        <td><input name="bookCoverimg" placeholder="도서표지"></td>
      </tr>
      <tr>
        <td>출판일자</td>
        <td><input name="bookDate" type="date"></td>
      </tr>
      <tr>
        <td>금액</td>
        <td><input name="bookPrice" type="number" placeholder="금액"></td>
      </tr>
      <tr>
        <td>출판사</td>
        <td><input name="bookPublisher" placeholder="출판사"></td>
      </tr>
      <tr>
        <td>도서소개</td>
        <td><input name="bookInfo" placeholder="도서소개"></td>
      </tr>
    </table>
    <button type="button" id="btnInsert">등록</button>
  </form>

<script>
btnInsert.addEventListener("click", function() {
  if (document.querySelector('.bookName').value == '') {
    alert('도서명이 입력되지 않았습니다');
    document.querySelector('.bookName').focus();
  } else {
	myForm.submit();
	alert('도서등록이 완료되었습니다.');
  }
});
</script>
</body>
</html>