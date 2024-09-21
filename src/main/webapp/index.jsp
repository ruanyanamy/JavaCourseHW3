<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Home</title>
    <link href="<%= request.getContextPath() %>/style/style.css" rel="stylesheet"></link>
</head>

<body>
    <!--<c:out value="test jstl">testing</c:out>-->
    <h2>| Game Home |</h2>
	<a href="<%= request.getContextPath() %>/lottery/main.jsp" class="btn">
		<button type="button">
			Lottery
		</button>
	</a>
	<a href="<%= request.getContextPath() %>/game/gameController.do" class="btn">
		<button type="button">
			Guess Number
		</button>
	</a>
</body>
</html>