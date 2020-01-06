<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CNTECH - HOMEWORK3 영업관리 데이터베이스</title>
</head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.css"
	rel="stylesheet" />
<link href="css/style.css" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.js"></script>
<script>
	var loadData = function(u, d) {
		$.ajax({
			url : u,
			data : d.serialize(),
			method : 'post',
			success : function(data) {
				if (u=="${contextPath}/monthlyCountList") {
					var $divObj = d.parent().find("#calendar");
					$divObj.empty();
					$divObj.html(data);
				} else {
					console.log("sucess");	
					var $divObj = d.parent().find("div.result");
					$divObj.empty();
					$divObj.html(data);
				}
			}
		});
		return false;
	};
	$(function() {
		$('ul.tab li').click(function() {
			var activeTab = $(this).attr('data-tab');
			$('ul.tab li').removeClass('current');
			$('.tabcontent').removeClass('current');
			$(this).addClass('current');
			$('#' + activeTab).addClass('current');
		});

		$("input:checkbox[name='selectType']").click(function() {
			var chk = $(this).is(":checked");//.attr('checked');
			if (chk) {
				$("table.detailTable #detailsearch").css("display", "none");
			} else {
				$("table.detailTable #detailsearch").css("display", "block");
			}
		});

		$('ul.tab li[data-tab=schedule]').click(function() {
			$('#calendar').fullCalendar({
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'month'
				},
				defaultDate : new Date()
			});
		});

		$('form').submit(function() {
			var id = $(this).attr('id');
			switch (id) {
			case 'selectTotalCount':
				loadData("${contextPath}/countSearch", $(this));
				break;
			case 'selectDetail':
				loadData("${contextPath}/detailSearch", $(this));
				break;
			case 'selectMonthly':
				loadData("${contextPath}/monthlyCountList", $(this));
				break;

			}
			return false;
		});

	});
</script>
<body>
	<div id="container">
		<ul class="tab">
			<li class="current" data-tab="total"><a href="#">건수</a></li>
			<li data-tab="detail"><a href="#">상세검색</a></li>
			<li data-tab="schedule"><a href="#">달력</a></li>
		</ul>
		<div id="total" class="tabcontent current">
			<form id="selectTotalCount">
				<table class="detailTable">
					<tr>
						<td colspan="2"><input type="checkbox" name="selectType"
							value="전체검색">전체검색</td>
					</tr>
					<tbody id="detailsearch">
						<tr>
							<td>기간</td>
							<td><input type="date" name="startDate"> ~ <input
								type="date" name="endDate"></td>
						</tr>
						<tr>
							<td>검색어</td>
							<td><select name="searchType"><option value="선택">선택</option>
									<option value="m.member_name">이름</option>
							</select> <input type="search" name="search"></td>
						</tr>
						<tr>
							<td>판매유형</td>
							<td><input type="checkbox" name="salesType" value="1">오프라인
								<input type="checkbox" name="salesType" value="2">온라인</td>
						</tr>
					</tbody>
				</table>
				<button type="submit">검색</button>
				<button type="reset">CLEAR</button>
			</form>
			<div class="result"></div>
		</div>
		<div id="detail" class="tabcontent">
			<form id="selectDetail">
				<table class="detailTable">
					<tr>
						<td colspan="2"><input type="checkbox" name="selectType"
							value="전체검색">전체검색</td>
					</tr>
					<tbody id="detailsearch">
						<tr>
							<td>기간</td>
							<td><input type="date" name="startDate"> ~ <input
								type="date" name="endDate"></td>
						</tr>
						<tr>
							<td>검색어</td>
							<td><select name="searchType"><option value="선택">선택</option>
									<option value="m.member_name">이름</option>
							</select> <input type="search" name="search"></td>
						</tr>
						<tr>
							<td>판매유형</td>
							<td><input type="checkbox" name="salesType" value="1">오프라인
								<input type="checkbox" name="salesType" value="2">온라인</td>
						</tr>
						<tr>
							<td>상세건수검색</td>
							<td><input type="search" name="detailsearch" placeholder="">
								<select name="detailsearchType"><option value="선택">선택</option>
									<option value="=">일치</option>
									<option value="<">초과</option>
									<option value=">">미만</option>
							</select> 검색</td>
						</tr>
					</tbody>
				</table>
				<button type="submit">검색</button>
				<button type="reset">CLEAR</button>
			</form>
			<div class="result"></div>
		</div>
		<div id="schedule" class="tabcontent">
			<form id="selectMonthly">
				<table>
					<tr>
						<td>기간</td>
						<td><input type="date" name="startDate"> ~ <input
							type="date" name="endDate">
							<button type="submit">검색</button>
							<button type="reset">CLEAR</button></td>
					</tr>
				</table>
			</form>
			<div id="calendar"></div>
		</div>
	</div>
</body>
</html>