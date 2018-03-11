package com.example.dev.the_food_house;

/**
 * Created by Admin on 3/9/2018.
 */

public class MenuCaiDat {
    private String Ten;
    private int Hinh;

    public MenuCaiDat(String ten, int hinh) {
        Ten = ten;
        Hinh = hinh;
    }
    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
