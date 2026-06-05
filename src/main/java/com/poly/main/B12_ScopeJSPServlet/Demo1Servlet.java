package com.poly.main.B12_ScopeJSPServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Demo1Servlet", value = "/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay session
        HttpSession session = request.getSession();
        String str = (String) session.getAttribute("message4");
        // dung gia tri str nhu bien request
        request.setAttribute("str1", str);
        request.getRequestDispatcher("/view/buoi12/demo1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
