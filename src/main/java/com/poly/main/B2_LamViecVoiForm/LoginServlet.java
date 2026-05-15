package com.poly.main.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet1", value = {
        "/login",
        "/ket-qua"
})
// value -> liet ke cac duong dan => nhieu duong dan { liet ke cac duoc dan}
// name co the xoa di -> value bat buoc phai ton tai
// Mot so loi hay gap Tomcat k buid duoc:
// 1. Duong dan bat dau bang dau /
// 2. Duong dan la duy nhat => trong project hien tai
// 3. Nghich web.xml
public class LoginServlet extends HttpServlet {
    // BE - servlet & FE - JSP
    // BE & FE trao doi vs nhau HTTP Method (Phuong thuc HTTP)
    // Co 4 phuong thuc HTTP Method: GET, POST, PUT, DELETE
    // JAV204 -> ky du 4 phuong thuc
    // JAV103 -> 2 phuong thuc: GET & POST
    // GET: Hien thi/Lay ra/ Xu ly du lieu(FORM) k can che giau thong tin tren form...
    // POST: LAM VIEC VOI FORM - DU LIEU CAN CHE GIAU THONG TIN
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // hien thi giao dien jsp: login-form.jsp (Chuyen trang)
        String name = "Hello world";
        // Truyen gia tri servlet -> jsp => setAttribute(ths1,ths2)
        // ths1: ten bien => jsp se dung
        // ths2: Object => gia tri cua ths1
        request.setAttribute("testValue", name);
        // chuyen trang
        request.getRequestDispatcher("/login-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //B1: nguoi dung nhap => Lay gia tri nguoi dung nhap
        // Lấy giá trị JSP -> servlet -> getParamter
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        // B2: Chuyen sang trang moi /ket-qua => hien thi du lieu B1 len trang moi
        request.setAttribute("u1", username);
        request.setAttribute("u2", password);
        // B3: Chuyen trang
        request.getRequestDispatcher("/ket-qua-form.jsp").forward(request, response);
    }
}
