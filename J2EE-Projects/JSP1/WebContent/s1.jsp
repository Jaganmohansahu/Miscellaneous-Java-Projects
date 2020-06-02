<%!
	int x = 10;

	String message()
	{
		return "Hello";
	}
%>

<b>Scriplet</b><br>
<%
	out.println("Value of x: " + x);
	out.println("Message from function: " + message());
%>
<hr>

<b>Expression</b><br>
Value of x: <%=x%><br>
Message from function: <%=message()%>