<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CNTECH - HOMEWORK2</title>
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.status!= 1}">
			<p>오류가 발생했습니다.</p>
		</c:when>
		<c:otherwise>
			<c:set var="list" value="${requestScope.list}" />
			<c:set var="price" value="${requestScope.price}" />
			<div>총 ${fn:length(list)} 가지</div>
			<c:forEach var="i" items="${list}">
				<span>${price} =</span>
				<c:forEach var="j" items="${i}" varStatus="status">
					<span>${j.value}</span>
					<span>X</span>
					<span>${j.count}</span>
					<c:if test="${status.last ne true}">
						<span>+</span>
					</c:if>
				</c:forEach>
				<br>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>