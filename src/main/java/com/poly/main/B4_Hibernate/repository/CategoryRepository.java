package com.poly.main.B4_Hibernate.repository;

import com.poly.main.B4_Hibernate.entity.Category1;
import com.poly.main.B4_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // Truy van => CRUD (CREATE, READ, UPDATE, DELETE)
    // Phien lam viec => Session (import - hibernate)
    private Session s;
    // Chi mo phien lam viec 1 lan duy nhat 1 Class

    public CategoryRepository() {
        // Mo phien 1 lan trong contructor
        s = HibernateUtil.getFACTORY().openSession();
    }

    // GET ALL => List/ArrayList  => import .util
    public List<Category1> getAll() {
//        String hql = "SELECT c FROM Category1 c";
        // neu trong TH => chi lam viec 1 bang hoac cau truy van k qua phuc tap
//        String hql1 = "FROM Category1";
        return s.createQuery("FROM Category1").list();
    }

    public Category1 getOne(Long id2) {
        return s.find(Category1.class, id2); // Chi ap dung vs khoa chinh
    }

    public void add(Category1 cate) {
        // tinh toan vien => transation
        try {
            // B1: Bat dau 1 transation
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang => persit
            s.persist(cate);
            // B3: Day du lieu di
            s.getTransaction().commit(); // Den day moi thuc su la thuc thi cau lenh
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback(); // Quay ve trang thai ban dau
        }
    }

    public void update(Category1 cate) {
        // tinh toan vien => transation
        try {
            // B1: Bat dau 1 transation
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang => merge
            s.merge(cate);
            // B3: Day du lieu di
            s.getTransaction().commit(); // Den day moi thuc su la thuc thi cau lenh
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback(); // Quay ve trang thai ban dau
        }
    }

    public void delete(Category1 cate) {
        // tinh toan vien => transation
        try {
            // B1: Bat dau 1 transation
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang => delete
            s.delete(cate);
            // B3: Day du lieu di
            s.getTransaction().commit(); // Den day moi thuc su la thuc thi cau lenh
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback(); // Quay ve trang thai ban dau
        }
    }

    // Category1 is not mapped
    // TH1: @Entity trong class mapping
    // TH2: Trong file Hibernate Util => chua dk class entity
    // Invalid column name 'caregory_code' => Mapping entity sai so vs SQl
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
