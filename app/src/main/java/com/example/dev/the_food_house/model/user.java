package com.example.dev.the_food_house.model;

import com.example.dev.the_food_house.Product;

import java.util.ArrayList;

/**
 * Created by dev on 4/11/2018.
 */

public class user {
    private String userName;
    private String ID;
    private String email;
    private String phone;
    private boolean isLogin;// true logged in
    private int point; //
    private ArrayList<coupon> listCoupon;
    private String avatar;
    private String background;
    private ArrayList<Product> listHis;

    public boolean CheckLogin(){
        return true;
    }

    public boolean Logout(){
        return true;
    }

    public boolean LoginWithPhone(String phone){
        return true;
    }

    public boolean LoginWithEmail(String Email){
        return true;
    }

    public boolean LoginWithFacebook(){
        return true;
    }

    public user(boolean isLogin, int point, String avatar, String background) {
        this.isLogin = isLogin;
        this.point = point;
        this.avatar = avatar;
        this.background = background;
    }

    public String getUserName() {
        return userName;
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public int getPoint() {
        return point;
    }

    public ArrayList<coupon> getListCoupon() {
        return listCoupon;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getBackground() {
        return background;
    }

    public ArrayList<Product> getListHis() {
        return listHis;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setListCoupon(ArrayList<coupon> listCoupon) {
        this.listCoupon = listCoupon;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setListHis(ArrayList<Product> listHis) {
        this.listHis = listHis;
    }
}
