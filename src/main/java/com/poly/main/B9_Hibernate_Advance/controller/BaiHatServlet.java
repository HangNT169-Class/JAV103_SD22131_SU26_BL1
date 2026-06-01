package com.poly.main.B9_Hibernate_Advance.controller;

import com.poly.main.B9_Hibernate_Advance.repository.BaiHatRepository;
import com.poly.main.B9_Hibernate_Advance.repository.CaSiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BaiHatRepository", value = "/bai-hat/hien-thi")
public class BaiHatServlet extends HttpServlet {
    private BaiHatRepository baiHatRepository = new BaiHatRepository();

    private CaSiRepository caSiRepository = new CaSiRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ve nha - load du lieu len table
        // Mai:
        // 1. Goi 1 ban len chua load table
        // 2. Chua load du lieu len combobox
        // 3. Huong dan lam chuc nang - search, sort, phan trang - 1 diem - kha gioi
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienthi(request, response);
        }
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBaiHat", baiHatRepository.getAll());
        request.setAttribute("listCaSi", caSiRepository.getAll());
        request.getRequestDispatcher("/buoi9/danh-sach-bai-hat.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
