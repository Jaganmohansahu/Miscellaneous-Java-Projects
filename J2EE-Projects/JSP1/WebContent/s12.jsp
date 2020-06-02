<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${'Hello welcome to JSTL'}"></c:out><br>
	<c:set var="x" value="123"></c:set><br>
	Value of x: <c:out value="${x}"></c:out><br>
	
	<c:if test="${x>100}">
	<c:out value="${'yes big number'}"></c:out>
	</c:if>
	
	<c:set var="mark" value="50"></c:set>
	<c:choose>
		<c:when test="${mark>30}">
			<c:out value="${'Yes Pass'}"></c:out>
		</c:when>
	<c:otherwise>
		<c:out value="${'No fails'}"></c:out>
	</c:otherwise>
	</c:choose><br>
	
	<c:forEach begin="1" end="10" step="3" var="i">
		<c:out value="${i}"></c:out><br>
	</c:forEach>
	
	<c:remove var="mark"/>
	Mark: <c:out value="${mark}"></c:out>
</body>
</html>