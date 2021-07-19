<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <p>write!!</p> 
</div>
  
<div class="container">
		<form role="form" method="post" action="/board/write">
			<table>
				<tbody>
					<tr>
						<td><label for="title">제목</label><input type="text"
							id="title" name="title" /></td>
					</tr>
					<tr>
						<td><label for="content">내용</label>
						<textarea id="content" name="content"></textarea></td>
					</tr>
					<tr>
						<td><label for="writer">작성자</label><input type="text"
							id="writer" name="writer" /></td>
					<tr>
						<td>
							<button type="submit">작성</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>