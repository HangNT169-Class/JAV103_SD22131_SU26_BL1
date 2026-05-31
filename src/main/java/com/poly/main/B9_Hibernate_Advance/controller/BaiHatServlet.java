package com.poly.main.B9_Hibernate_Advance.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BaiHatRepository", value = "/bat-hat/hien-thi")
public class BaiHatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ve nha - load du lieu len table
        // Mai:
        // 1. Goi 1 ban len chua load table
        // 2. Chua load du lieu len combobox
        // 3. Huong dan lam chuc nang - search, sort, phan trang - 1 diem - kha gioi
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
