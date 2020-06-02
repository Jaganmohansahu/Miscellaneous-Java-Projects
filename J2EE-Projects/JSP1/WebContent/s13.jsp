<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="s" value="${'JSP is simple'}"></c:set>
	Length of String: <c:out value="${fn:length(s)}"></c:out><br>
	
	<c:if test="${fn:contains(s, 'is')}">
		<c:out value="${'yes Present'}"></c:out><br>
	</c:if>
	
	<c:out value="${fn:startsWith(s, 'JSP')}"></c:out><br>
	<c:out value="${fn:endsWith(s, 'e')}"></c:out><br>
	<c:out value="${fn:toUpperCase(s)}"></c:out><br>
</body>
</html>