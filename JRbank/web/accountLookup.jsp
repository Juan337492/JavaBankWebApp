<%-- 
    Juan Rodriguez
    Lab 4
    this is my code.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: teal;">
    <h1 style="margin-left: 45%;margin-top: 10%;color: white;font-family: Helvetica, sans-serif;font-size: 2em;
text-shadow: 2px 2px black;">Account Look Up</h1>
    <div class="loginPrompt" style="border-style: solid;border-width: 1px;padding-bottom: 5em;">
        <form action="http://localhost:8080/JRbank/AccountLookupServlet" style="margin-left: 45%;margin-top: 7%;color: white;font-size: 20px;">
            <label for="customerId">Customer ID :</label><br>
            <input type="text" id="customerId" name="CustomerId" placeholder="Customer ID"><br>
            <br>
            <label for="AcctNo">Account Number :</label><br>
            <input type="text" id="AcctNo" name="AccountNo" placeholder="Account Number"><br>
            <br>
            <label for="AcctType">Account Type :</label><br>
            <input type="text" id="AccType" name="AcctType" placeholder="Account Type"><br>
            <br>
            <label for="Balance">Balance :</label><br>
            <input type="text" id="Balance" name="Balance" placeholder="Account Balance"><br>
            <br><br>
            <input type="submit" value="Look Up">
            <input type="reset" value="Clear">
        </form>
    </div>
</body>
</html>
