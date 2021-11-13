<%-- 
    Juan Rodriguez
    Lab 6
    this is my code.
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Account"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <body style="background-color: teal;">
            <%
            Account a1;
            a1 = (Account)session.getAttribute("a1");
            a1.display();
            

            %>
            
    <h1 style="margin-left: 45%;margin-top: 10%;color: white;font-family: Helvetica, sans-serif;font-size: 2em;
text-shadow: 2px 2px black;">Account Look Up</h1>
    <div class="loginPrompt" style="border-style: solid;border-width: 1px;padding-bottom: 5em;">
        <form style="margin-left: 45%;margin-top: 7%;color: white;font-size: 20px;">
            <label for="customerId">Customer ID :</label><br>
            <input type="text" id="customerId" name="CustomerId" placeholder="Customer ID" value="<%=a1.getCid()%>"><br>
            <br>
            <label for="AcctNo">Account Number :</label><br>
            <input type="text" id="AcctNo" name="AccountNo" placeholder="Account Number" value="<%=a1.getAcctNo()%>"><br>
            <br>
            <label for="AcctType">Account Type :</label><br>
            <input type="text" id="AccType" name="AcctType" placeholder="Account Type" value="<%=a1.getType()%>"><br>
            <br>
            <label for="Balance">Balance :</label><br>
            <input type="text" id="Balance" name="Balance" placeholder="Account Balance" value="<%=a1.getBalance()%>"><br>
            <br><br>
           
        </form>
    </div>
</body>
</html>
