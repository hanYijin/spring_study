<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  		<nav class="navbar navbar-expand-sm bg-light navbar-light">
  			<ul class="navbar-nav">
  				<li class="nav-item">
      				<a class="nav-link" href='<c:url value="/"/>'>HOME</a>
    			</li>
    			<li class="nav-item active">
      				<a class="nav-link" href='<c:url value="/board/list"/>'>게시판</a>
    			</li>
    		</ul>
    	</nav>
    </header>
    <div class="container">
  		<h1>게시판</h1>
  	</div>
  	<hr/>
  	<div class="container">
  	<form action="/board/update" method="post">
  		<table class="table table-hover" style="text-align: center; border: 2px solid=#dddddd;">
  			<thead>
  				<thead>
  				
					<th colspan="3" style="background-color: #84A4BF; text-align: center;">게시글</th>
				</thead>
				<tbody>
				<%-- <c:forEach items="${read}" var="read"> --%>
				<fmt:parseDate value='${read.redate}' var='redate' pattern='yyyymmdd'/>
					<tr>
						<td Style="width:20%;">글 제목</td>
					    <td colspan="2"><input type="text" placeholder="${read.title}" value="${read.title}" class="form-control" name="title" id="title" maxlegth="50"></td>
					</tr>
					<tr>
						<td Style="width:20%;">작성자</td>
					    <td colspan="2">${read.userid}</td>
					</tr>
					<tr>
						<td Style="width:20%;">작성일자</td>
					    <td colspan="2"><fmt:formatDate value="${redate}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td Style="width:20%;">내용</td>
					    <td colspan="2">${read.content}</td>
					</tr>
				</tbody>
  		</table>
  	</form>
</body>
</html>