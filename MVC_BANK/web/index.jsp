<%-- 
    Document   : index
    Created on : May 29, 2018, 4:32:58 PM
    Author     : Jagan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="bank.controller.Deposit" method="post">
            <pre>
            <font color="Red" size="14">
            <center>
                <%
                    String status = request.getParameter("status");
                    if(status!=null)
                    {
                        if(status.equals(-1))
                            out.print("Account Number does not exists");
                        else if(status.equals(1))
                            out.print("Account Number Updated Successfully!!");
                        else 
                            out.print("Error in Updation");
                    }
                    %>
                    </center>
            </font>
                <center>
                    <hr>Enter the details...<hr>
                </center>
                Account No: <input type="text" name="actno"><br>
                Amount: <input type="text" name="amount"><br>
                    <input type="submit" value="Deposit">              
            </pre>
        </form>
    </body>
</html>
