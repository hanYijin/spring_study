<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import= "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>게시판</title>
</head>
<body>
	<header>
  		<%@include file="navbar.jsp" %>
    </header>
    <div class="container">
  		<h1>게시판</h1>
  	</div>
  	<hr/>
  	<div class="container">
  	<form action="/board/write" method="post">
  		<table class="table table-hover" style="text-align: center; border: 2px solid=#dddddd;">
  			<thead style="background-color: #84A4BF; text-align: center;">
  				<tr>
  					<td>번호</td>
  					<td>제목</td>
  					<td>작성자</td>
  					<td>작성일</td>
  				</tr>
  			</thead>
  			<tbody>
  			<c:forEach items="${list}" var = "list">
  			<%-- <fmt:parseDate value='${list.redate}' var='redate' pattern='yyyymmdd'/> --%>
  				<tr>
  					<td><a href="/board/readView?bno=${list.bno}"><c:out value="${list.bno}"/></a></td>
  					<td><a href="/board/readView?bno=${list.bno}"><c:out value= "${list.title}"/></a></td>
  					<td><c:out value= "${list.userid}"/></td> 
  					<td><%-- <fmt:formatDate value="${redate}" pattern="yyyy-MM-dd"/> --%><c:out value="${list.redate}"/></td>
  				</tr>
  			</c:forEach>
  			</tbody>
  		</table>
  	</form>
  		<a href='<c:url value='/board/writeView'/>' role="button" class="btn btn-primary">글쓰기</a>
  	</div>

</body>
</html>