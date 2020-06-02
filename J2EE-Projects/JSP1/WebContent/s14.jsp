<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="system" var="db"/>
	
	<sql:query var="rs" dataSource="${db}">
		select * from student
	</sql:query>
	
	<table border="2" width="100%">
	<tr>
		<th>ROLL</th>
		<th>NAME</th>
		<th>AGE</th>
	</tr>
	
	<c:forEach var="table" items="${rs.rows}">
		<tr>
			<td><c:out value="${table.roll}"></c:out></td>
			<td><c:out value="${table.name}"></c:out></td>
			<td><c:out value="${table.age}"></c:out></td>
		</tr>
	</c:forEach>
	
	<sql:update dataSource="${db}">
		Update student set name='Jagu' where roll=101
	</sql:update>
	
	<sql:update dataSource="${db}">
		Delete from student where name='Jagu'
	</sql:update>
	
	<c:set var="r" value="${101}"></c:set>
	<sql:update dataSource="${db}">
		Update student set name='Rajesh' where r=?
		<sql:param value="${roll}"></sql:param>
	</sql:update>
	</table>
</body>
</html>