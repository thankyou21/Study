<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter Trainee Details:</h1>
	<table>
		<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
		<f:form action="add.obj" modelAttribute="tdetails">
			<tr>
				<td>Enter Trainee Name:</td>
				<td><f:input path="traineeName"/></td>
				<td><f:errors cssStyle="color:red" path="traineeName"/></td>
			</tr>
			<tr>
				<td>Choose Trainee Location:</td>
				<td><f:radiobutton path="traineeLoc" value="Pune"/>Pune
					<f:radiobutton path="traineeLoc" value="Mumbai"/>Mumbai
					<f:radiobutton path="traineeLoc" value="Chennai"/>Chennai
					<f:radiobutton path="traineeLoc" value="Delhi"/>Delhi
				</td>
				<td><f:errors cssStyle="color:red" path="traineeLoc"/></td>
			</tr>
			<tr>
				<td>Choose Trainee Domain:</td>
				<td><f:select path="traineeDom">
						<option value="BI">BI</option>
						<option value="JEE">JEE</option>
					</f:select></td>
				<td><f:errors cssStyle="color:red" path="traineeDom"/></td>
			</tr>
			<tr><td colspan=2><input type="submit" Value="Add Trainee"/></td></tr>
		</f:form>
	</table>
	
</body>
</html>