<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Play Lottery</title>
	<link href="<%= request.getContextPath() %>/style/style.css" rel="stylesheet"></link>
</head>
<body>
	<h2>| Play Lottery! |</h2>
	<h4>請輸入要產生的樂透組數及要排除的樂透號碼</h4>
	<form action="lotteryController.do" method="post">
		<table border="0" style="margin: auto; text-align: Left">
			<tbody>
				<tr>
					<td>組數</td>
					<td><input type="text" name="group" value="${ param.group }" placeholder="ex: 5"></td>
				</tr>
				<tr>
	    			<td>排除號碼</td>
	    			<td>
	    				<input type="text" name="excludenumber" size=40 value="${ param.excludenumber }" placeholder="ex: 10 25 19 6 24">
	    			</td>
	    		</tr>
	    		<tr>
	    		<td></td>
	    		<td>
	    			<a href="../" class="hbtn"><button type="button">回首頁</button></a>
	    			<input type="submit" value="送出" class="subbtn">
	    		</td>
	    		</tr>
			</tbody>
		</table>
	</form>
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