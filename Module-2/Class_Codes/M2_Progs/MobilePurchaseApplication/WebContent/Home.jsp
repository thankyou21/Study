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
	<h3>Mobiles Available:</h3>
	<table>
		<c:forEach var="mob" items="${mlist}">
			<tr>
				<td>${mob.mobileId}</td>
				<td>${mob.mobileName}</td>
				<td>${mob.price}</td>
				<td>
					<a href="buy.obj?mid=${mob.mobileId}">Buy</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>