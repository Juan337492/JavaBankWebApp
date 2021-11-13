<%-- 
   Juan Rodriguez
   Lab #6 
   I wrote this code myself...
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Login</title>
    </head>
    <body>
     
        <%
            Customer c5;
            c5 = (Customer)session.getAttribute("c5");
            c5.display();
           
            %>
          
            <h2>User with ID <%=c5.getCustID()%>, invalid password.</h2>
            
    </body>
</html>
