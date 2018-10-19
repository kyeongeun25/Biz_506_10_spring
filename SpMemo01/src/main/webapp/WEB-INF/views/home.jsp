<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<%@ include file="/WEB-INF/include/include-head.jspf" %>
</head>
<body class="w3-container">
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<%@ include file="/WEB-INF/include/include-nav.jspf" %>
<section class="w3-panel w3-topbar w3-bottombar w3-border-green">
	<c:choose>
		<c:when test="${BODY == 'LIST' }">
			<%@ include file="/WEB-INF/body/memo_list.jsp" %>
		</c:when>

		<c:when test="${BODY == 'WRITE'}">
			<%@ include file="/WEB-INF/body/memo_write.jsp" %>
		</c:when>
		<c:when test="${BODY == 'MEMO_VIEW' }">
			
			<h4>카테고리:${MEMO.memoCat }</h4>
			<h4>중요도:${MEMO.flag }</h4>
			<h4>날짜:${MEMO.date }</h4>
			<h4>제목:${MEMO.subject }</h4>
			<h4>메모내용:${MEMO.memoText }</h4>

		</c:when>
		<c:when test="${BODY == 'JOIN_FORM'}">
			<%@ include file="/WEB-INF/body/member_join.jsp" %>
		</c:when>
		<c:otherwise>
			<h3>반갑습니다</h3>
		</c:otherwise>
	</c:choose>
</section>
<%@ include file="/WEB-INF/include/include-footer.jspf" %>
</body>
</html>
