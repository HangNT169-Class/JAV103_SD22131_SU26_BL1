package com.poly.main.B11_Hibernate_Advance_P2.repository;

import com.poly.main.B11_Hibernate_Advance_P2.entity.Ban;
import com.poly.main.B11_Hibernate_Advance_P2.util.HibernateUtil;
import com.poly.main.B9_Hibernate_Advance.repository.BaiHatRepository;
import org.hibernate.Session;

import java.util.List;

public class BanRepository {
    private Session s;
    public BanRepository(){
        s = HibernateUtil.getFACTORY().openSession();
    }
    public List<Ban>getAll(){
        return s.createQuery("from Ban ").list();
    }

    public static void main(String[] args) {
        System.out.println(new BanRepository().getAll());
    }
}
