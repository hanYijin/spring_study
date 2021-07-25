<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Imagetoolbar" content="no" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>게시판</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[name='readForm']");
		
		// 취소 
		$("#cancel_btn").on("click", function(){
			event.preventDefault();
			location.href = "/board/readView?bno=${update.bno}"
				   + "&page=${scri.page}"
				   + "&perPageNum=${scri.perPageNum}"
				   + "&searchType=${scri.searchType}"
				   + "&keyword=${scri.keyword}";			
		})
		$(".update_btn").on("click", function(){
			if(fn_valiChk()){
				return false;
			}
			formObj.attr("action", "/board/update");
			formObj.attr("method", "post");
			formObj.submit();
		})
		$('#update_btn').click(function() {

			if ($('#title').val() == "") {
				swal("실패!", "제목을 입력하세요", "error");
				return false;
			}
			if ($('#content').val() == "") {
				swal("실패!", "내용을 입력하세요.", "error");
				return false;
			}
		});
	})

</script>

<body>
	<header>
		<%@include file="navbar.jsp" %>
    </header>

    <div class="container">
  		<h1>게시판</h1>
  	</div>
  	<hr/>
  	<div class="container">
  	<form name="updateForm" role="form" action="/board/update" method="post">
  	<input type="hidden" name="bno" value="${update.bno}" readonly="readonly"/>
<%--   	<c:forEach items="${read}" var="read"/>
 --%>  		<table class="table table-hover" style="text-align: center; border: 2px solid=#dddddd;">
  			<thead>
  				<thead>
  				
					<th colspan="3" style="background-color: #84A4BF; text-align: center;">게시글</th>
				</thead>
				<tbody>
				<%-- <c:forEach items="${read}" var="read"> --%>
				<fmt:parseDate value="${update.redate}" var='redate' pattern='yyyymmdd'/>
					<tr>
						<td Style="width:20%;">글 제목</td>
					    <td colspan="2"><input type="text" value="<c:out value='${update.title}'/>" class="form-control" name="title" id="title" maxlegth="50"></td>
					</tr>
					<tr>
						<td Style="width:20%;">작성자</td>
						<td colspan="2"><c:out value='${update.userid}'/></td>
					</tr>
					<tr>
						<td Style="width:20%;">작성일자</td>
					    <td colspan="2">${update.redate}</td>
					</tr>
					<tr>
					    <td Style="width:20%;">내용</td>
					    <td colspan="2">
					    	<textarea class="form-control" value="<c:out value='${update.content}'/>"id="content" name="content"maxlegth="1000" style="height:350px;"><c:out value='${update.content}'/></textarea>
					    </td>
					</tr>
				</tbody>
  		</table>
  		<button type="submit" id="update_btn" class="btn btn-warning">수정</button>
  		<button type="submit" id="cancel_btn" class="btn btn-primary">취소</button>
  	</form>
</body>
</html>