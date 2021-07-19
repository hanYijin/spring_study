<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>게시판</title>
</head>
<script type="text/javascript">
/* $(document).on('click', '#btnDelete', function(){

    var url = "${pageContext.request.contextPath}/delete";

    	url = url + "?bno=" + ${read.bno}};
		attr("method","post");
		submit;
		location.href = "/board/list";

	}); */
	$(document).ready(function(){
		var formObj = $("form[name='readForm']");
		
		// 수정 
		$("#update_btn").on("click", function(){
			
			formObj.attr("action", "/board/updateView");
			formObj.attr("method", "get");
			formObj.submit();				
		})
		
		// 삭제
		$("#delete_btn").on("click", function(){
			var deleteYN = confirm("삭제하시겠습니까?");
			if(deleteYN == true){
			formObj.attr("action", "/board/delete");
			formObj.attr("method", "post");
			formObj.submit();
			}
		})
		
		// 취소
		$("#list_btn").on("click", function(){
			
			location.href = "/board/list";
		})
	})
		
	/* $(document).ready(function(){ */
		/* $(document).getElementById('update').onclick=function(){
			location.href="${pageContext.request.contextPath}/board/updateView";
		});
		$(document).getElementById('delete').onclick=function(){
			location.href="${pageContex.request.contextPath}/board/delete";
		}); */

	/* }) */
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
  		<form name="readForm" method="post">
			<input type="hidden" id="bno" name="bno" value="${read.bno}" />
		</form>
  		<table class="table table-hover" style="text-align: center; border: 2px solid=#dddddd;">
  			<thead>
  				<thead>
					<th colspan="3" style="background-color: #84A4BF; text-align: center;">게시글</th>
				</thead>
				<tbody>
				<%-- <c:forEach items="${read}" var="read"> --%>
				<%-- <fmt:parseDate value='${read.redate}' var='redate' pattern='yyyymmdd'/> --%>
					<tr>
						<td Style="width:20%;">글 제목</td>
					    <td colspan="2">${read.title}</td>
					</tr>
					<tr>
						<td Style="width:20%;">작성자</td>
					    <td colspan="2">${read.userid}</td>
					</tr>
					<tr>
						<td Style="width:20%;">작성일자</td>
					    <td colspan="2">${read.redate}<%-- <fmt:formatDate value="${redate}" pattern="yyyy-MM-dd"/> --%></td>
					</tr>
					<tr>
						<td Style="width:20%;">내용</td>
					    <td colspan="2">${read.content}</td>
					</tr>
				</tbody>
  		</table>
  		<div>
  			<button type="submit" id="update_btn" class="btn btn-warning">수정</button>
  			<button type="submit" id="delete_btn" class="btn btn-danger">삭제</button>
			<button type="submit" id="list_btn" class="btn btn-primary">목록</button>
  		</div>
  		
</body>
</html>