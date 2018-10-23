<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FTF Query Found</title>
</head>
<body>
	<!--  this page shows the fetched query details -->
	<h1>Fortune Technical </h1>
	<h2>Query Details:</h2>
	<h4>Query ID: ${qdetails.queryId }</h4>
	<h4>Technology:  ${qdetails.technology }</h4>
	<h4>Question:  ${qdetails.query }</h4>
	<h4>Question Raised By:  ${qdetails.queryRaisedBy }</h4>
	<br>
	<h2><a href="Home.jsp">Home</a></h2>
</body>
</html>