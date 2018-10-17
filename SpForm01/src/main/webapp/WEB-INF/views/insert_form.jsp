<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/include/include-head.jspf" %>

<script>
$(function(){
	// $("btnSave").click(function());
	$("#btnSave").on("click",function(){
		// alert("저장 버튼 클릭")
		var userName = $("#username").val()
		var addr = $("#addr").val()
		var telno = $("#telno").val()
		var email = $("#email").val()
		
		// 이름을 입력하시 않았으면
		if(userName == "") {
			alert("이름을 입력하세요")
			$("#username").focus()
			return false
		}
		if(addr == "") {
			alert('주소를 입력하세요')
			$("#addr").focus()
			return false;
		}
		
		var emailTest = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(email == "") {
			alert('이메일을 입력하세요')
			$("#email").focus()
			return false
		}
		
		if(! emailTest.test(email)) {
			alert('이메일이 형식에 맞지 않습니다')
			$('#email').focus()
			return false
		}
		
		// 전송을 실행하라
		$('form').submit()
		
	})
})
</script>

</head>
<body class="w3-container w3-margin">
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
<section class="w3-panel w3-padding-16">
<form action="/form01/insert_ok.do" method="post">
	<label class="w3-label">이름</label>
	<input 
		placeholder="이름을 입력하세요"
		class="w3-input w3-border" 
		type="text" 
		name="username" id="username">
	
	<label>주소</label>
	<input  
		placeholder="주소를 입력하세요"
		class="w3-input w3-border" 
		type="text" 
		name="addr" id="addr">
	
	<label>전화번호</label>
	<input  
		placeholder="전화번호를 입력하세요"
		class="w3-input w3-border" 
		type="tel" 
		name="telno" id="telno">

	<label>이메일</label>
	<input  
		placeholder="이메일을 입력하세요"
		class="w3-input w3-border" 
		type="email" 
		name="email" id="email">

	<button
		type="button"
		id="btnSave" 
		class="w3-button w3-blue w3-input" >저장</button>

</form>
</section>
<%@ include file="/WEB-INF/include/include-footer.jspf" %>
</body>
</html>
