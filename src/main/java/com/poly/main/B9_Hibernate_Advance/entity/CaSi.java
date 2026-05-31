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

@Entity
@Table(name = "ca_si")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CaSi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_ca_si")
    private String tenCaSi;

    @Column(name = "que_quan")
    private String queQuan  ;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Column(name = "cong_ty")
    private String congTy;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

}
