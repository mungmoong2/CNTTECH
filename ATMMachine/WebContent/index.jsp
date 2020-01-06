<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CNTECH - HOMEWORK2</title>
</head>
<script type="text/javascript">
	var i = 0;

	function addForm() {
		var divObj = document.createElement('div');
		var InputObj1 = document.createElement("INPUT");
		InputObj1.setAttribute("type", "text");
		InputObj1.setAttribute("placeholder", "value");
		InputObj1.setAttribute("Name", "list["+i+"].value");
		InputObj1.setAttribute("Required","required");
		
		var InputObj2 = document.createElement("INPUT");
		InputObj2.setAttribute("type", "text");
		InputObj2.setAttribute("placeholder", "count");
		InputObj2.setAttribute("Name", "list["+i+"].count");
		InputObj2.setAttribute("Required","required");

		divObj.appendChild(InputObj1);
		divObj.appendChild(InputObj2);
		divObj.setAttribute("id", "coin_" + i);
		document.getElementById("coins").appendChild(divObj);
		
		i++;
	} 

	function delForm() {
		var formObj = document.getElementById("coins");
		if (i > 1) {
			var divObj = document.getElementById("coin_" + (--i));
			formObj.removeChild(divObj);
		} else {
			document.baseForm.reset();
		}
	}
</script>

<body onload="addForm();">
	<form name="baseForm" action="${contextPath}/coin" method="post">
		가격 <input type="text" name="price" placeholder="가격을 입력하세요" required> <br>
		<input type="Button" value="추가" onclick="addForm()"> <input
			type="Button" value="삭제" onclick="delForm()"><br> 
			<div id="coins">동전금액
		갯수 
		</div> <input type="Submit" value="완료">
	</form>
</body>
</html>