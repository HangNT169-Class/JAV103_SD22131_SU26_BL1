<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 3/6/26
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select>
    <c:forEach var="i" items="${listMQH}">
        <option>
                ${i.ten}
        </option>
    </c:forEach>
</select>
<table border="1">
    <thead>
    <tr>
        <th>MA BAN</th>
        <th>Ten Ban</th>
        <th>So thich</th>
        <th>Ma moi quan he</th>
        <th>Ten moi quan he</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="b" items="${listBan}">
        <tr>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.soThich}</td>
            <td>
                    ${b.idMQH.ma}
            </td>
            <td>
                    ${b.idMQH.ten}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
