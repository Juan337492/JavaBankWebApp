<%-- 
    Juan Rodriguez
    Lab 6
    this is my code.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            String hello = "Hello";
            
            for (int n = 0; n <=6 ;){
            n = n + 1;
             %><h<%=n%>>    <%=hello%>   </h<%=n%>><%
            }
            %>
    </body>
</html>
