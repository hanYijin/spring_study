<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Smart MyFarm</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  			<ul class="navbar-nav">
  				<li class="nav-item">
      				<a class="nav-link" href='<c:url value="/"/>'>HOME</a>
    			</li>
    			<li class="nav-item active">
      				<a class="nav-link" href='<c:url value="../board/list"/>'>My Farm Stroy</a>
    			</li>
    			<li class="nav-item dropdown">
      				<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">회원관리</a>
      				<div class="dropdown-menu">
        				<c:if test="${member == null}"><a class="dropdown-item" href="<c:url value='../Member/loginView'/>">로그인</a></c:if>
        				<c:if test="${member != null}"><a class="dropdown-item" href="/Member/logout">로그아웃</a></c:if>
        				<a class="dropdown-item" href="<c:url value='/Member/signup'/>">회원가입</a>
      				</div>
    			</li>
    		</ul>
    	</nav>
<!-- 로그인 양식 -->
<div class="container">
<h1>
	Smart MyFarm  
</h1>
<script type="text/javascript">
	$(document).ready(function(){
		$("#logoutBtn").on("click", function(){
			location.href="Member/logout";
		})
		$("#signup").on("click", function(){
			location.href="Member/signup";
		})
		$("#updateBtn").on("click", function(){
			location.href="Member/memberUpdateView";
		})
	})
</script>
<form name='homeForm' method="post" action="/Member/login">
		<c:if test="${member == null}">
			<div class="form-inline" style="float: right;">
				<label for="id">아이디</label>
				<input type="text" id="id" name="id">
				<label for="pw">비밀번호</label>
				<input type="password" id="pw" name="pw">
				<button type="submit" class="btn btn-primary btn-sm ml-3">로그인</button>
				<button type="button" id="signup"class="btn btn-primary btn-sm ml-2">회원가입</button>
			</div>
		</c:if>
		<c:if test="${member != null }">
			<div class="jumbotron" style="float: right;">
				<h5>${member.id}님 환영 합니다.</h5>
				<button id="updateBtn" type="button" class="btn btn-primary btn-sm ml-2">회원정보 수정</button>
				<button id="logoutBtn" type="button" class="btn btn-primary btn-sm ml-2">로그아웃</button>
			</div>
		</c:if>
		<c:if test="${msg == false}">
			<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>
	</form>
</div>
</body>
</html>
