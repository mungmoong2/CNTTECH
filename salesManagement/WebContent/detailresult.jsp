<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${requestScope.status!= 1}">
		<p>오류가 발생했습니다.</p>
	</c:when>
	<c:otherwise>
		<c:set var="list" value="${requestScope.list}" />
		<table>
			<tr>
				<td>사원아이디</td>
				<td>사원이름</td>
				<td>영업날짜</td>
				<td>영업타입</td>
				<td>영업건수</td>
			</tr>
			<c:forEach var="i" items="${list}">
				<tr>
					<td>${i.member_id}</td>
					<td>${i.member.member_name}</td>
					<td>${i.sales_date}</td>
					<td>${i.salestype.sales_name}</td>
					<td>${i.sales_count}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
