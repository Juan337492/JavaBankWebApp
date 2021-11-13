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
            String teamName = "Go braves";
            int n = 0;
            for (n = 1;n <= 10;){
            n = n + 1;
        %><h1><%=teamName%></h1><%
            }

            %>
         
    </body>
</html>
