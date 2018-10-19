<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	
	$("#btnSave").on("click",function(){
		if(confirm("저장할까요?")) {
			$("form").submit()	
		}
		
	})

})
</script>
<form action="/memo01/write_ok.memo" method="POST">

	<label>카테고리</label>
	<select name="memoCat" class="w3-input w3-border">
		<option value="CAT_THINK">오늘의 생각</option>
		<option value="CAT_WORK">오늘의 할일</option>
		<option value="CAT_PROMISE">약속</option>
		<option value="CAT_VISIT">방문할곳</option>
		<option value="CAT_ETC">기타</option>
	</select>
	
	<label class="">중요도</label>
	<input type="radio" name="flag" value="FLAG_TOP">중요
	<input type="radio" name="flag" value="FLAG_MID">보통
	<input type="radio" name="flag" value="FLAG_LOW">일반
	
	<label>작성일자</label>
	<input type="date" name="date" class='w3-input w3-border'>

	<label>메모제목</label>
	<input type="text" name="subject"  class='w3-input w3-border'>

	<label>메모</label>
	<textarea rows="5" name="memoText" class='w3-input w3-border'></textarea>
	
	<button type="button" id="btnSave">저장</button>

</form>