<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<font color="green" size=15>
	<center>
		<%
			String status = request.getParameter("status");
		if(status != null)
		{
			if(status.equals("0"))
				out.print("Error in user registration!!");
			else
				out.print("User Added successfully...");
		}
		%>
	</center>
	</font>
	<jsp:include page="addUserForm.html"></jsp:include>
</body>
</html>