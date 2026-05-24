package com.poly.main.B4_Hibernate.controller;

import com.poly.main.B4_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = {
        "/category/hien-thi",  // GET
        "/category/detail", // GET
        "/category/delete", // GET
        "/category/view-update", // GET
        "/category/update", // POST
        "/category/view-add", // GET
        "/category/add", // POST
        "/category/search", // GET
})
public class CategoryServlet extends HttpServlet {

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 6 get => do...get
        // B1: Lay ra uri tren duong dan
        String uri = request.getRequestURI();
        //   System.out.println("Test" + uri);
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailDuLieu(request, response);
        } else if (uri.contains("delete")) {
            // delete
            this.deleteDuLieu(request, response);
        } else if (uri.contains("view-update")) {
            // view-update
            this.viewUpdateDuLieu(request, response);
        } else if (uri.contains("view-add")) {
            // view-add
            this.viewAddDuLieu(request, response);
        } else {
            // TH con lai: search
            this.searchDuLieu(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2 post => do...post
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            // add
            this.addDuLieu(request, response);
        } else {
            // update
            this.updateDuLieu(request, response);
        }
    }

    private void deleteDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // co list => repo.getAll
        request.setAttribute("listCate",categoryRepository.getAll());
        request.getRequestDispatcher("/buoi3/categorys.jsp").forward(request,response);
    }

    private void updateDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }
}
