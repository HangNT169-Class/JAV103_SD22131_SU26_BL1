package com.poly.main.B4_Hibernate.controller;

import com.poly.main.B4_Hibernate.entity.Category1;
import com.poly.main.B4_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

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

    private void deleteDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri truyen tren duong dan => Lay gia tri jsp -> servlet
        String id = request.getParameter("id");
        // B2: lay doi tuong ra dua vao id
        Category1 cate = categoryRepository.getOne(Long.valueOf(id));
        // B3: Thuc hien chuc nang xoa
        categoryRepository.delete(cate);
        // B4: Quay ve trang chu => /category/hien-thi
        response.sendRedirect("/category/hien-thi");
//        request.setAttribute("listCate",categoryRepository.getAll());
//        request.getRequestDispatcher("/buoi3/categorys.jsp").forward(request,response);
    }

    private void viewUpdateDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri truyen tren duong dan => Lay gia tri jsp -> servlet
        String id = request.getParameter("id");
        // B2: lay doi tuong ra dua vao id
        Category1 cate = categoryRepository.getOne(Long.valueOf(id));
        // B3: Day doi tuong detail.jsp
        request.setAttribute("cate1", cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/buoi3/update-cate.jsp").forward(request, response);
    }

    private void viewAddDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi3/add-category.jsp").forward(request, response);
    }

    private void searchDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri truyen tren duong dan => Lay gia tri jsp -> servlet
        String id = request.getParameter("id2");
        // B2: lay doi tuong ra dua vao id
        Category1 cate = categoryRepository.getOne(Long.valueOf(id));
        // B3: Day doi tuong detail.jsp
        request.setAttribute("cate1", cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/buoi3/detail-cate.jsp").forward(request, response);
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // co list => repo.getAll
        request.setAttribute("listCate", categoryRepository.getAll());
        request.getRequestDispatcher("/buoi3/categorys.jsp").forward(request, response);
    }

    private void updateDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    @SneakyThrows
    private void addDuLieu(HttpServletRequest request, HttpServletResponse response) {
        // B1: Lay du lieu tu o input
        Category1 cate = new Category1();
        // BeanUtil -> lay tat ca
        // Tu dong mapping toan bo gia tri input: radio, checkbox...
        // MAPPING NAME => NAME INPUT PHAI TRUNG NAME TRONG ENTITY
        BeanUtils.populate(cate, request.getParameterMap());
//        String name = request.getParameter("")
        // B2: Goi chuc nang add
        categoryRepository.add(cate);
        // B3: Chuyen trang
        response.sendRedirect("/category/hien-thi");
    }
}
