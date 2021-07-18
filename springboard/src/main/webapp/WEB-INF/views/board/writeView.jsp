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
  		<%@include file="navbar.jsp" %>
    </header>
    <div class="container">
  		<h1>게시판</h1>
  	</div>
  	<hr/>
  	<div class="container">
  		<form role="form" action="/board/write" method="post">
			<table class="table" style="text-align: center; border: 1px solid=#dddddd;">
				<thead>
					<th>게시판 글 작성</th>
				</thead>
				<tbody>
					<tr>
						<td>
							<input type="text" class="form-control" placeholder="제목" name="title" maxlegth="50" id="title"/>
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" class="form-control" placeholder="작성자" name="userid" maxlegth="45" id="userid"/>
						</td>
					</tr>
					<tr>
						<td>
							<textarea type="text" class="form-control" placeholder="내용" id="content" name="content" maxlegth="1000" style="height:350px;"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<button type="submit" class="btn btn-primary">작성완료</button>
						</td>
					</tr>
				</tbody>
			</table> 		
  		</form>
  	</div>
</body>
</html>