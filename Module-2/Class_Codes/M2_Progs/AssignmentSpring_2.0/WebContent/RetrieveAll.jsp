<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	<h2>All Trainee Records:</h2>
	<table>
		<c:forEach var="trainee" items="${tlist}">
			<tr>
				<td>${trainee.traineeId}</td>
				<td>${trainee.traineeName}</td>
				<td>${trainee.traineeDom}</td>
				<td>${trainee.traineeLoc}</td>
			</tr>
		</c:forEach>
		<tr><td colspan=4><h3></h3><a href="Operation.jsp" >Go to Dashboard</a></h3></td></tr>
	</table>
</body>
</html>