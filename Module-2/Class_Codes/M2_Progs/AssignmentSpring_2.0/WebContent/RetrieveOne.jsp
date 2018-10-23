<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Trainee Details:</h2>
	<h3>Trainee ID: ${tdetails.traineeId }</h3>
	<h3>Trainee Name:  ${tdetails.traineeName }</h3>
	<h3>Location:  ${tdetails.traineeLoc }</h3>
	<h3>Domain:  ${tdetails.traineeDom }</h3>
	
	<h2><a href="Operation.jsp" >Go to Dashboard</a></h2>
</body>
</html>