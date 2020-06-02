<%@ include file="s9.jsp" %>
<hr>

Value of ID: <%= pageContext.getAttribute("id", pageContext.SESSION_SCOPE) %>