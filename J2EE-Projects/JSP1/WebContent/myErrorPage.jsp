<%@ page isErrorPage="true" %>

<%=exception%>
<hr>

<%
	pageContext.setAttribute("id", 123, pageContext.SESSION_SCOPE);
%>
<a href="s16.jsp">CLICK HERE</a>