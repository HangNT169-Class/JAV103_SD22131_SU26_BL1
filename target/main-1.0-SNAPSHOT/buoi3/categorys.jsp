<%--taglist => khai bao de su dung jstl => import jstl trong pom--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="/category/view-add">Add Cate</a></button>
<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Cate Code</th>
        <th>Cate name</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%--    for...each =>JSTL : c:...
    for(Doi tuong dt : lists){
    items: gia tri list lay tu servlet
    var: hien thi Object
    varStatus : vi tri trong mang = 0
    }
    Ten bien entity: category_name
    --%>
    <c:forEach items="${listCate}" var="cate" varStatus="i">
        <tr>
            <td>${i.index +1}</td>
            <td>${cate.id1}</td>
            <td>${cate.categoryCode}</td>
                <%-- GETTER: _ => k the goi tuong getter         --%>
            <td>${cate.categoryName}</td>
            <td>
                <%--Cach truyen gia tri tren duong dan
                                ?tenbien=giaTri. Bat dau tu ths2 &tenBien=giatri--%>
                <a href="/category/delete?id=${cate.id1}">Delete</a>
                <a href="/category/detail?id2=${cate.id1}">Detail</a>
                <%--view-update--%>
                <a href="/category/view-update?id=${cate.id1}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
