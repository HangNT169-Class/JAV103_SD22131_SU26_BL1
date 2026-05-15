<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 13/5/26
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${testValue}
<form method="POST" action="/ket-qua">
    <%--Muon lay gia tri cua input => input: name--%>
    Username : <input type="text" name="uname"/> <br/>
    Password : <input type="password" name="pass"/> <br/>
    <button type="submit">
        Login
    </button>
</form>
</body>
</html>
