<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Values from session</h1>
	ROLL: <%= session.getAttribute("roll") %><br>
	NAME: <%= session.getAttribute("name") %><br>
	AGE: <%= session.getAttribute("age") %><br>
	
	<%
		session.invalidate();
	%>
	<a href="s7.jsp">CLICK HERE FOR S7</a>
</body>
</html>