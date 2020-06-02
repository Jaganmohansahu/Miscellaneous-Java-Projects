<%@page import="com.db.Users"%>
<%@page import="com.model.UsersDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
		<th>USER ID</th>
		<th>USER NAME</th>
		<th>EMAIL ID</th>
		<th>AGE</th>
		</tr>
	<%
		List<Users> list = UsersDao.getAllRecords();
	
		for(Users u:list)
		{
			%>
			<tr>
				<td><%=u.getUserid() %></td>
				<td><%=u.getUsername() %></td>
				<td><%=u.getEmailid() %></td>
				<td><%=u.getAge() %></td>
				</tr>
	<% 
		}
	%>
	</table>
</body>
</html>