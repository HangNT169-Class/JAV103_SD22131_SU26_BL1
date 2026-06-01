package com.poly.main.B9_Hibernate_Advance.repository;

import com.poly.main.B9_Hibernate_Advance.entity.BaiHat;
import com.poly.main.B9_Hibernate_Advance.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class BaiHatRepository {
    private Session s;

    public BaiHatRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<BaiHat> getAll() {
        return s.createQuery("FROM BaiHat ").list();
    }

    // search & sort & phan trang
    // Code hibernate -> day jsp: servlet
    public List<BaiHat> timKiemTheoKhoangGia(Double giaMin, Double giaMax) {
        // B1: Viet cau lenh hql
        String hql = "SELECT b FROM BaiHat b WHERE b.gia > ?1 AND b.gia < ?2";
        // B2: Tao query
        Query q = s.createQuery(hql);
        // Rieng trong HQl -> ? => kem theo vi tri
        q.setParameter(1, giaMin);
        q.setParameter(2, giaMax);
        // B3: return list
        return q.getResultList();
    }

    public List<BaiHat> sapXepTheoTen() {
        // B1: Viet cau lenh hql
        String hql = "SELECT b FROM BaiHat b ORDER BY b.tenBaiHat DESC";
        // B2: Tao query
        Query q = s.createQuery(hql);
        // B3: return list
        return q.getResultList();
    }

    // Phan trang -> gui
    // phan trang => dung offset trong SQL

    /**
     * -- giai thich ham nay la gi lam gi
     *
     * @param pageNo:   gt gia tri cua bien nay: so Trang (trang so 1, trang 2..)
     * @param pageSize: so luong phan tu trong 1 trang
     * @return : gt gia tri tra ve
     */
    public List<BaiHat> phanTrangSQl(Integer pageNo, Integer pageSize) {
        // TRANG DAU TIEN BAT DAU BANG 0
        Integer offset1 = pageNo * pageSize;
        // B1: Tao cau lenh SQL
//        String sql = "SELECT * from category " +
//                "ORDER BY id  " +
//                "OFFSET :offset ROWS \n" +
//                "FETCH NEXT :pageSize1 ROWS ONLY ";
        String sql = "select * from bai_hat ORDER BY id  OFFSET :offset ROWS FETCH NEXT :pageSize1 ROWS ONLY;";
//        String sql1="select * from category\n" +
//                "ORDER BY id \n" +
//                "OFFSET9 ROWS \n" +
//                "FETCH NEXT 3 ROWS ONLY ";
        // B2: Tao query
        Query query = s.createNativeQuery(sql, BaiHat.class);
        // B3: Set value
        query.setParameter("offset", offset1);
        query.setParameter("pageSize1", pageSize);
        return query.getResultList();
    }

    public List<BaiHat> phanTrangHQl(Integer pageNo, Integer pageSize) {
        int offset = pageNo * pageSize;
        String hql = "SELECT p FROM BaiHat p  ORDER BY p.id ";
        Query query = s.createQuery(hql);
        query.setFirstResult(offset); // NGANG HANG VS OFFSET => KET QUA TRA RA LA +1
        query.setMaxResults(pageSize); // SO LUONG MAX/TRANG
        return query.getResultList();
    }

    public static void main(String[] args) {
        System.out.println(new BaiHatRepository().timKiemTheoKhoangGia(100D, 500D));
    }
}
