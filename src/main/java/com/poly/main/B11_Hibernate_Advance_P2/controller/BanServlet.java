package com.poly.main.B11_Hibernate_Advance_P2.controller;

import com.poly.main.B11_Hibernate_Advance_P2.repository.BanRepository;
import com.poly.main.B11_Hibernate_Advance_P2.repository.MQHRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BanServlet", value = "/BanServlet")
public class BanServlet extends HttpServlet {
    private BanRepository banRepository = new BanRepository();
    private MQHRepository mqhRepository = new MQHRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBan", banRepository.getAll());
        request.setAttribute("listMQH", mqhRepository.getAll());
        request.getRequestDispatcher("/ban-table.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
