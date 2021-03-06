package com.example.dev.the_food_house.model;


import android.content.Context;
import android.database.Cursor;

import com.example.dev.the_food_house.Product;
import com.example.dev.the_food_house.SignupActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
    private String password;
    private String password_cof;



    public String getPassword() {
        return password;
    }

    public String getPassword_cof() {
        return password_cof;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword_cof(String password_cof) {
        this.password_cof = password_cof;
    }

    public boolean CheckLogin(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference session = database.getReference("session");
        //delete session
        session.child(phone);
        return true;
    }

    public boolean Logout(Context a){

        DBAdapter db = new DBAdapter(a);
        db.open();
        String sdt = db.getCurrentUser();
        db.close();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference session = database.getReference("session");
        //delete session
        session.child(sdt).setValue("false");
        //
        return true;
    }

    public String LoginWithPhone(final String phone, final String password){
      return "";
    }

    public String SignupWithPhone(Function<String,String> function){
      return "";
    }

    public user(boolean flag) {
        if(flag){
            this.isLogin = true;
            this.point = 100;
            this.avatar = "https://firebasestorage.googleapis.com/v0/b/thefoodhouse3.appspot.com/o/user_default_avarta.jpg?alt=media&token=882c9a15-0ec0-44e7-9042-da76e1f1c58b";
            this.background = "https://firebasestorage.googleapis.com/v0/b/thefoodhouse3.appspot.com/o/bokho.jpeg?alt=media&token=8dee2cf9-dcef-490a-a287-f79fde2142a6";
            this.userName = "levanchon";
            this.ID = "0";
            this.email = "example@gmail.com";
            this.phone = "0976655443";
        }
    }

    public user(){}

    public String getUserName() {
        return "levanchon1";
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

    public boolean isLogin(Context ct) {
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
