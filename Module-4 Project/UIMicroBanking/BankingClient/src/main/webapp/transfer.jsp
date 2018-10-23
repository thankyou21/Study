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
<f:form action ="fundtransfer" method="post" modelAttribute="ut">
	<table>
	<tr><td colspan="2"><h2><b>Transfer Funds</b></h2></td></tr>
	<tr><td>UserId: </td><td><f:input path="userId" name="userId"/><br/></td></tr>
	<tr><td>From Account: </td><td><f:input path="fromAc" name="fromAc"/><br/></td></tr>
	<tr><td>To Account: </td><td><f:input path="toAc" name="toAc"/><br/></td></tr>
	<tr><td>Amount: </td><td><f:input path="amt" name="amt"/><br/></td></tr>
	<tr><td>Transaction Password: </td><td><f:input path="tnxPassword" name="tnxPassword"/><br/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Transfer"/></td></tr>
	</table>
</f:form>
</body>
</html>