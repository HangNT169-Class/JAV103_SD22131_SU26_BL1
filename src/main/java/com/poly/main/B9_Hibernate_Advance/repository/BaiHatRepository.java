package com.poly.main.B9_Hibernate_Advance.repository;

import com.poly.main.B9_Hibernate_Advance.entity.BaiHat;
import com.poly.main.B9_Hibernate_Advance.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class BaiHatRepository {
    private Session s;
    public BaiHatRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }
    public List<BaiHat> getAll(){
        return s.createQuery("FROM BaiHat ").list();
    }

    public static void main(String[] args) {
        System.out.println(new BaiHatRepository().getAll());
    }
}
