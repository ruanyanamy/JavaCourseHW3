<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess Wrong</title>
<link href="<%= request.getContextPath() %>/style/style.css" rel="stylesheet"></link>
</head>
<body>
	<h2>| Guess Wrong |</h2>
	<h3>非常抱歉您沒猜中....</h3>
	<h4>本次的幸運號碼為<%= request.getAttribute("luckynum") %></h4>
	<% session.invalidate(); %>
	<h4>
		<form action="gameController.do" method="get">
			<a href="../" class="hbtn"><button type="button">回首頁</button></a>
			<input type="submit" value="再玩一次!" class="subbtn">
		</form>
	</h4>	
</body>
</html>