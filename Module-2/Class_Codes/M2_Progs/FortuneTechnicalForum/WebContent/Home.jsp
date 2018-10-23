<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FTF Home</title>
</head>
<body>
	<!--  Home Page -->
	<h1>Fortune Technical Forum</h1>
	<form action="search.obj">
		Query ID: 
		<input type="text" name="queryId" pattern="[0-9]+" title="This feild accepts numbers only." required> 
		<input type="submit" value="Search">
	</form>
</body>
</html>