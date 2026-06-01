<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 1/6/26
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select>
    <c:forEach items="${listCaSi}" var="caSi">
        <option>${caSi.tenCaSi}</option>
    </c:forEach>
</select>
<table border="1" cellpadding="10"cellspacing="0">
    <thead>
    <tr>
        <th>ten bai hat</th>
        <th>ten tac gia</th>
        <th>thoi luong </th>
        <th>ngay san suat</th>
        <th>gia</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBaiHat}" var="a">
        <tr>
            <td>${a.tenBaiHat} </td>
            <td>${a.tenTacGia} </td>
            <td>${a.thoiLuong}</td>
            <td>${a.ngaySanXuat}</td>
            <td>${a.gia}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
