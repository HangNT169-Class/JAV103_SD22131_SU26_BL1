package com.poly.main.B12_Ajax.controller;

import com.google.gson.Gson;
import com.poly.main.B12_Ajax.entity.SinhVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjaxServlet", value = "/api/sinh-vien/hien-thi")
public class AjaxServlet extends HttpServlet {
    // CHI TAO RA JSON THÔI -> JSP LAY JSON DE HIEN THI
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Tao ra du lieu
        List<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien("SV01", "Nguyen Van A", 10, "Nam"));
        listSinhVien.add(new SinhVien("SV02", "Nguyen Van B", 11, "Nữ"));
        listSinhVien.add(new SinhVien("SV03", "Nguyen Van C", 12, "Nam"));
        listSinhVien.add(new SinhVien("SV04", "Nguyen Van D", 13, "Nữ"));
        listSinhVien.add(new SinhVien("SV05", "Nguyen Van E", 15, "Nam"));
        // B2: Chuyển đổi dữ liệu Object (nói chung) -> Json
        Gson g = new Gson();
        // Chuyen doi gson -> json
        String responseData = g.toJson(listSinhVien);
        // B3: Set type cho loai chuyen doi
        response.setContentType("application/json");
        // B4: Muon du lieu hien thi tren truyen duyet => Chi mang tinh chat test tam thoi
        PrintWriter out = response.getWriter();
        // B5: Gui du lieu cho client
        out.println(responseData);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
