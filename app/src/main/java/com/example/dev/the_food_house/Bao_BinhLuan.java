package com.example.dev.the_food_house;

/**
 * Created by Admin on 4/20/2018.
 */

public class Bao_BinhLuan {
    private String tenUser;
    private String binhLuan;
    private int baiBaoId;
    public Bao_BinhLuan(){}
    public Bao_BinhLuan( int baiBaoId,String tenUser, String binhLuan){
        this.tenUser = tenUser;
        this.binhLuan = binhLuan;
        this.baiBaoId = baiBaoId;
    }
    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public int getBaiBaoId() {
        return baiBaoId;
    }

    public void setBaiBaoId(int baiBaoId) {
        this.baiBaoId = baiBaoId;
    }
}
