<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
  <h1>FreeBoard</h1>
  <p>write and read</p> 
</div>
  
<div class="container">
  <div class="row">
  	<form role="form" method="post" action="/board/write">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>이메일</th>
				<th>등록일</th>
			</tr>		
			<c:forEach items="${list}" var = "list">
				<tr>
					<td><c:out value="${list.idx}" /></td>
					<td><c:out value="${list.title}" /></td>
					<td><c:out value="${list.name}" /></td>
					<td><c:out value="${list.email}"/></td>
					<td><fmt:formatDate value="${list.wdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</table>
	</form>
  </div>
</div>
	

</body>
</html>