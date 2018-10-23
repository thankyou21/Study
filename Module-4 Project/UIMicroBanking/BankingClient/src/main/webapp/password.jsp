<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Banking System</h2>
<br>

<f:form action ="changepwd" method="post" modelAttribute="ut">
	<table>
	<tr><td colspan="2"><h2><b>Change Password</b></h2></td></tr>
	<tr><td>UserId: </td><td><f:input path="userId" name="userId"/><br/></td></tr>
	<tr><td>Old Password: </td><td><f:input path="oldPassword" name="oldPassword"/><br/></td></tr>
	<tr><td>New Password: </td><td><f:input path="newPassword" name="newPassword"/><br/></td></tr>
	<tr><td>Confirm New Password: </td><td><f:input path="confirmNewPassword" name="confirmNewPassword"/><br/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Change"/></td></tr>
	</table>
</f:form>
</body>
</html>