<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 5/6/26
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajax demo</h1>
<button onclick="clickData()">Click me</button>
<table border="1">
    <thead>
    <tr>
        <th>Ma SV</th>
        <th>Ten SV</th>
        <th>Tuoi SV</th>
        <th>Gioi tinh SV</th>
    </tr>
    </thead>
    <tbody id="tbody-data">

    </tbody>
</table>
</body>
<%--Them thu vien jquery--%>
<script src="https://code.jquery.com/jquery-4.0.0.min.js"
        integrity="sha256-OaVG6prZf4v69dPg6PhVattBXkcOWQB62pdZ3ORyrao=" crossorigin="anonymous"></script>
<script>
    function clickData() {
        // Xay dung cu phap ajax
        $.ajax({
            url:"/api/sinh-vien/hien-thi", // Duong dan tu BE
            type:"GET", // HTTP Method
            dataType:"json", // Dinh danh nhan ve
            success: function (response){
                console.log(response)
                let html =''
                for(let sv of response){
                    html+= "<tr>";
                    html+= "<td>" + sv.maSV + "</td>";
                    html+= "<td>" + sv.tenSV + "</td>";
                    html+= "<td>" + sv.tuoi + "</td>";
                    html+= "<td>" + sv.gioiTinh + "</td>";
                    html+= "</tr>";
                }
                // Hien thi du lieu cua bien html -> vao tbody
                document.getElementById("tbody-data").innerHTML = html
            },
            errors: function (){
                // TH loi
                console.log("Loi goi API GET")
            }
        })
    }
</script>
</html>
