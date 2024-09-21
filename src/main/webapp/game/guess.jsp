<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Play Guess</title>
<link href="<%= request.getContextPath() %>/style/style.css" rel="stylesheet"></link>
</head>
<body>
	<h2>| Guess Number |</h2>
	<h3>請猜猜1~<%= session.getAttribute("range") %>中的數字</h3>
	<form action="gameController.do" method="post">
		<h4>您還剩餘<%= session.getAttribute("remainchance") %>次機會可以猜</h4>
		<input type="text" name="getnum" size=6 placeholder="ex: 5">
		<input type="submit" value="Guess!" class="subbtn">
	</form>
	<br/>
	<a href="../" class="hbtn"><button type="button">回首頁</button></a>
	<br/>
	<% LinkedList<String> errors = (LinkedList<String>)request.getAttribute("error"); %>
	<% if (errors != null){ %>
		<ul style="color: red; font-size: 14px">
			<table border="0" style="margin: auto; text-align: Left">
				<% for (String error : errors){ %>
					<tr><td># <%= error %><td></tr>
				<% } %>
			</table>
		</ul>
	<% } %>
</body>
</html>