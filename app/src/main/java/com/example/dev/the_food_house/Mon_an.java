package com.example.dev.the_food_house;

import java.io.Serializable;

/**
 * Created by Admin on 5/10/2018.
 */

public class Mon_an implements Serializable {
    private  int IdMonAn;

    private String TenMonAn;
    private String HuongDanNauAn;

    public int getIdMonAn() {
        return IdMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        IdMonAn = idMonAn;
    }

    public Mon_an(int idMonAn, String tenMonAn, String huongDanNauAn) {
        IdMonAn = idMonAn;
        TenMonAn = tenMonAn;
        HuongDanNauAn = huongDanNauAn;
    }

    public String getTenMonAn() {

        return TenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        TenMonAn = tenMonAn;
    }

    public Mon_an() {
    }

    public String getHuongDanNauAn() {
        return HuongDanNauAn;
    }

    public void setHuongDanNauAn(String huongDanNauAn) {
        HuongDanNauAn = huongDanNauAn;
    }

}