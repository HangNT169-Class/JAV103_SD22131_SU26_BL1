package com.poly.main.B9_Hibernate_Advance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "bai_hat")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaiHat {
    /**
     * Cac kieu du lieu khi mapping => KIEU OBJECT : CHU CAI DAU VIET HOA
     * LOI NULL VALUE => SQL XOA DONG DU LIEU BI NULL
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_bai_hat")
    private String tenBaiHat;

    @Column(name = "ten_tac_gia")
    private String tenTacGia;
    @Column(name = "thoi_luong")
    private Integer thoiLuong;

    @Column(name = "ngay_san_xuat")
    private Date ngaySanXuat;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "ca_si_id")
    private Integer caSiId;

    @Column(name = "phat_hanh_dia", insertable = false, updatable = false)
    private Boolean phatHanhDia;

    @Column(name = "ngay_ra_mat")
    private Date ngayRaMat;

}
