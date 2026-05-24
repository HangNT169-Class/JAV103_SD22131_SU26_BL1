package com.poly.main.B4_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// import -> jakarta
@Entity // Danh dau day la thuc the de truy van
@Table(name = "category") // Ten cua table -> SQL
// import -> lombox
@Getter
@Setter
@ToString
@NoArgsConstructor // contructor k ts
@AllArgsConstructor // cocntructor full ts
@Builder // custom contructor tuy y tham so
public class Category1 {
    /**
     * Hibernate -> mapping - ORM(Object Relationship Mapping) => K truy van bang SQL
     * => Truy van tren thuc the (tat ca cac class trong entity) => K co select *
     * SELECT * From category ->table -> JDBC
     * SELECT c FROM Category1 c -> Hibernate -> Thuc the (Ten Class): HQL
     * => Mapping table
     * thuoc tinh:
     * 1. Thuoc tinh binh thuong
     * 2. Thuoc tinh => khoa chinh
     * 3. Thuoc tinh => khoa ngoai
     */
    @Id
    // Neu khoa chinh tu tang
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // cot bt table
    @Column(name = "id")
    private Long id1;

    @Column(name = "category_code") // ten cot SQL
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
