<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(function(){

	$(".memo_select").on("click",function(){
		var id = $(this).attr('data-id')
		// alert(id)
		$(location).attr('href','view.memo?id=' + id)
	})
})


</script>

<c:choose>
	<c:when test="${empty MEMOS  }">
		<h3>메모가 없습니다</h3>
	</c:when>
	<c:otherwise>
		<table class="w3-table w3-border w3-striped w3-hoverable">
			<tr class='w3-border'>
				<th>카테고리</th>
				<th>중요도</th>
				<th>날짜</th>
				<th>제목</th>
			</tr>
			<!-- 리스트 본문 표시 -->
			<c:forEach items="${MEMOS}" var="item">
				<tr class='w3-border memo_select' 
					data-id="${item.id}">
					<td>${item.cValue}</td>
					<td>${item.fValue}</td>
					<td>${item.date}</td>
					<td>${item.subject}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>



