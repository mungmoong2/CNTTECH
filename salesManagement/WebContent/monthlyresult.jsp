<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
var dataset =[
	<c:set var="list" value="${requestScope.list}" />
	<c:forEach var="i" items="${list}" varStatus="status">
	{"start":'<c:out value="${i.sales}"/>'
	,"title":'영업건수 <c:out value="${i.cn}"/> 건'
	}<c:if test="${!status.last}">,</c:if>
	</c:forEach>
	];
$(function() {
	$('#resultcalendar').fullCalendar({
		header : {
			left : 'prev,next today',
			center : 'title',
			right : 'month'
		},
		defaultDate : '${requestScope.startDate}',
		events: dataset
	});
	
});
</script>

<div id="resultcalendar"></div>
<div id="detailCount">
	<c:choose>
		<c:when test="${requestScope.status!= 1}">
			<p>오류가 발생했습니다.</p>
		</c:when>
		<c:otherwise>
			<c:set var="list" value="${requestScope.list}" />
			<table>
				<tr>
					<td>영업날짜</td>
					<td>영업건수</td>
				</tr>
				<c:forEach var="i" items="${list}">
					<tr>
						<td>${i.sales}</td>
						<td>${i.cn}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</div>