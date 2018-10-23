<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Modify Trainee:</h2>
	<form action="edit.obj">
		<table>
			<tr>
				<td>Enter Trainee ID:</td>
				<td><input type="text" name="traineeId"/></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" Value="Update Trainee with this ID"/></td>
			</tr>
			<tr>
				<td colspan=2><a href="Operation.jsp" >Go to Dashboard</a></td>
			</tr>
		</table>
	</form>
</body>
</html>