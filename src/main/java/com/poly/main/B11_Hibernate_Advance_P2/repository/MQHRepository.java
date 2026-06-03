package com.poly.main.B11_Hibernate_Advance_P2.repository;

import com.poly.main.B11_Hibernate_Advance_P2.entity.MQH;
import com.poly.main.B11_Hibernate_Advance_P2.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MQHRepository {
    private Session s;
    public MQHRepository(){
        s  = HibernateUtil.getFACTORY().openSession();
    }
    public List<MQH>getAll(){
        return s.createQuery("from MQH ").list();
    }

    public static void main(String[] args) {
        System.out.println(new MQHRepository().getAll());
    }
}
