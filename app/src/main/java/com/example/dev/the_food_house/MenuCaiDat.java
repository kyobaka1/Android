package com.example.dev.the_food_house;

/**
 * Created by Admin on 3/9/2018.
 */

public class MenuCaiDat {
    private String Ten;
    private int Hinh;

    private MenuCaiDat(String ten, int hinh) {
        Ten = ten;
        Hinh = hinh;
    }
    private String getTen() {
        return Ten;
    }

    private void setTen(String ten) {
        Ten = ten;
    }

    private int getHinh() {
        return Hinh;
    }

    private void setHinh(int hinh) {
        Hinh = hinh;
    }
}
