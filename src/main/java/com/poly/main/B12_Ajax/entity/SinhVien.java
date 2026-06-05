package com.poly.main.B12_Ajax.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SinhVien {
//    Tạo 1 đối tượng SinhVien gớm các thuộc tính: maSV - String, tenSV - String ,
//    tuoi - int, gioiTinh - String và các contructor, getter, setter

    private String maSV;

    private String tenSV;

    private int tuoi;

    private String gioiTinh;

}
