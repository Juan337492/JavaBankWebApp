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
        <title>Login</title>
    </head>
    <body style="background-color: teal;">
    <a href="index.html" style="position: absolute;margin-left: 10%;margin-top:2%;text-decoration: none;color: whitesmoke;">Home</a>
    <h1 style="margin-left: 45%;margin-top: 10%;color: white;font-family: Helvetica, sans-serif;font-size: 2em;
text-shadow: 2px 2px black;">
        Login
    </h1>
    <div class="loginPrompt" style="border-style: solid;border-width: 1px;padding-bottom: 4em;">
        <form action="http://localhost:8080/JRbank/LoginServlet" method="post" accept-charset="utf-8" style="margin-left: 45%;margin-top: 8%;color: white;font-size: 20px;" >
            <label for="id">Customer ID :</label><br>
            <input type="text" id="customerId" name="id" placeholder="ID"><br>
            <br>
            <label for="password">Password :</label><br>
            <input type="password" id="pass" name="password" placeholder="Password" >
            <br><br>
            <input type="submit" value="Login">
            <input type="reset" value="Clear">
        </form>
    </div>
</body>
</html>
