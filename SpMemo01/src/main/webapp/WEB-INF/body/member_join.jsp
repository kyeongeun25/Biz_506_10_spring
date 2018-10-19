<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	


	$("#btnJoin").on("click",function(){
		
		var username = $("#username").val();
		var password = $("#password").val();
		var re_password = $("#re_password").val();

		// email 체크
		
		
		// alert(password + password.length)
		if(password.length < 8) {
			alert("비밀번호는 8자 이상으로 입력하세요")
			$('#password').focus()
			return false;
		}
		
		//          ! =
		if(password != re_password) {
			alert("비밀번호와 비밀번호 확인이 서로 다릅니다 \n" +
					"다시 입력하세요")
					
			$("#password").val("")
			$("#re_password").val("")
			$("#password").focus()
			return false
		}
		
		$('form').submit()
		
		
	})
	
	
})

</script>
 <article class="w3-panel w3-row w3-center">

	<form action="join_ok.member" method="POST"> 	
 	<div class="w3-col m3 l3 s3"></div>
 	<label class="w3-col m5 l5 s5">이메일
 		<input class='w3-input w3-border' 
 			type="email" id="username" name="username">
 	</label>

	<div class="w3-col m3 l3 s3"></div>
	<label class="w3-col m5 l5 s5">비밀번호
		<input  class='w3-input w3-border' 
			type="password" id="password" name="password">
	</label> 

	<div class="w3-col m3 l3 s3"></div>
	<label class="w3-col m5 l5 s5">비밀번호확인
		<input  class='w3-input w3-border' 
			type="password" id="re_password" name="re_password">
	</label> 

	<div class="w3-col m3 l3 s3"></div>
	<button type="button" id="btnJoin"
		class='w3-col m5 l5 s5 w3-blue'>회원가입</button>
	</form>
 </article>   