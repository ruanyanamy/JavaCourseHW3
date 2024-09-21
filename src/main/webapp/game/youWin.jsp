<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess Right</title>
<link href="<%= request.getContextPath() %>/style/style.css" rel="stylesheet"></link>
</head>
<body>
	<h2>| Guees Right! |</h2>
	<h3>恭喜您猜中啦~!!</h3>
	<h4>本次的幸運號碼就是<%= request.getAttribute("luckynum") %>!</h4>
	<a href="../" class="hbtn"><button type="button">回首頁</button></a>
	<% session.invalidate(); %>
</body>
</html>