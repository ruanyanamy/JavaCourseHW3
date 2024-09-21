<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery Result</title>
<link href="<%= request.getContextPath() %>/style/style.css" rel="stylesheet"></link>
</head>
<body>
	<h2>| Lottery Result |</h2>
	<% 
		ArrayList<String> result = (ArrayList<String>) request.getAttribute("res");
    	int group = Integer.parseInt((String)request.getAttribute("group"));
	%>
	<h4>為您生成<%= group %>組樂透號碼</h4>
	<h4>您排除的樂透號碼: <%= request.getAttribute("exclude") %></h4>
	<table border="0" style="margin: auto; text-align: Left; font-size: 16px;">
		<tbody>	
			<% 
			int index = 0;
			for (int i=1;i<=group;i++){%>			
			<tr>
				<td>您的第<%= i %>組樂透號碼: </td>
				<td>
					<% for (int j = 0; j < 6; j++) { 
						out.print(result.get(index)+" ");       
		                index++;
			        } %> 
		        </td>
	        </tr>
			<% } %>
		</tbody>
	</table>
	<br/>
	<a href="../" class="hbtn"><button type="button">回首頁</button></a>
</body>
</html>