package com.poly.main.B11_Hibernate_Advance_P2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ban")
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String ma;

    @Column
    private String ten;

    @Column(name = "so_thich")
    private String soThich;

    @Column(name = "gioi_tinh")
    private Integer gioiTinh;

    // NEU XAC DINH LAM NHU 2 BANG DOC LAP RIENG BIET
    // KHONG SUA ENTTIY
    // XAC DINH LAM JOIN BANG THI SUA TRUONG KHOA NGOAI
    // RIENG KHOA NGOAI => KHONG MAPPING NHU BT
    // MAPPING DOI TUONG
//    @Column(name = "id_mqh")
    // XAC DINH MQH GIUA BAN & MQH LA QH GI
    // 1 BAN -> 1 MQH
    // 1 MQH -> N BAN
    @ManyToOne
    @JoinColumn(name = "id_mqh")
    private MQH idMQH;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
