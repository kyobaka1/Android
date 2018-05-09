package com.example.dev.the_food_house;

/**
 * Created by Admin on 4/20/2018.
 */

public class Bao_BinhLuan {
    private String key;
    private String tenUser;
    private String binhLuan;
    private String avarta;
    private int baiBaoId;
    public Bao_BinhLuan(){}
    public Bao_BinhLuan( int baiBaoId,String tenUser,String avarta, String binhLuan){
        this.tenUser = tenUser;
        this.binhLuan = binhLuan;
        this.baiBaoId = baiBaoId;
        this.avarta = avarta;
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

    public String getAvarta() {
        return avarta;
    }
    public void setAvarta(String avarta) {
        this.avarta = avarta;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
