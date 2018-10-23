<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
	<f:form action="purchase.obj" modelAttribute="pdetails">
		Enter Customer Name:
		<f:input path="custName"/>
		<f:errors cssStyle="color:red" path="custName"/><br>
		
		Enter Customer Number:
		<f:input path="phoneNo"/>
		<f:errors cssStyle="color:red" path="phoneNo"/><br>
		
		Enter Customer Mail ID:
		<f:input path="mailId"/>
		<f:errors cssStyle="color:red" path="mailId"/><br>
		
		Enter Purchase Date:
		<f:input path="purchaseDate"/>
		<f:errors cssStyle="color:red" path="purchaseDate"/><br>
		
		<f:hidden path="mobileid"/>
		
		<input type="submit" Value="Buy Now"/>
	</f:form>
</body>
</html>