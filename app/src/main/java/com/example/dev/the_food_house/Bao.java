package com.example.dev.the_food_house;

/**
 * Created by Admin on 4/5/2018.
 */

public class Bao {
    private String Ten;
    private String Hinh;
    private String thoidiem;
    private String doanvan1;
    private String Hinh2;
    private String doanvan2;

    public Bao() {
    }

    public Bao(String ten, String hinh, String thoidiem, String doanvan1, String hinh2, String doanvan2) {
        Ten = ten;
        Hinh = hinh;
        this.thoidiem = thoidiem;
        this.doanvan1 = doanvan1;
        Hinh2 = hinh2;
        this.doanvan2 = doanvan2;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }

    public String getThoidiem() {
        return thoidiem;
    }

    public void setThoidiem(String thoidiem) {
        this.thoidiem = thoidiem;
    }

    public String getDoanvan1() {
        return doanvan1;
    }

    public void setDoanvan1(String doanvan1) {
        this.doanvan1 = doanvan1;
    }

    public String getHinh2() {
        return Hinh2;
    }

    public void setHinh2(String hinh2) {
        Hinh2 = hinh2;
    }

    public String getDoanvan2() {
        return doanvan2;
    }

    public void setDoanvan2(String doanvan2) {
        this.doanvan2 = doanvan2;
    }
}
