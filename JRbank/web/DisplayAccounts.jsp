<%-- 
    Juan Rodriguez
    Lab 7
    this is my code.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Customer"%>
<%@page import="Business.Account"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Accounts</title>
    </head>
    <body style="background-color: teal; text-align: center; margin-top: 15em; color: white;">

        <% 
        Account a1;
  
        
        Customer c5;
        c5 = (Customer)session.getAttribute("c5");
      
        int accounts = c5.aList.count;
        for (int n = 0 ; n < accounts; n++){
         a1 = c5.aList.accArr[n];
        

    
        %>
        <div id="accountData" style="border: 1px black solid;">
            <tr >
                <td><p>Account Number: </p><%=a1.getAcctNo()%></td>
            <br>
                <td><p>Customer ID: </p><%=a1.getCid()%></td>
            <br>            
                <td><p>Account Type: <p><%=a1.getType()%></td>
            <br>
                <td><p>Account Balance: <p><%=a1.getBalance()%></td>
</tr>
<% } %>
    </div>
                        
    </body>
</html>
