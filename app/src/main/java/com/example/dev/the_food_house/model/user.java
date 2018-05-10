package com.example.dev.the_food_house.model;


import com.example.dev.the_food_house.Product;
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
    private String message;


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

    public boolean Logout(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference session = database.getReference("session");
        //delete session
        session.child(phone).setValue("false");
        return true;
    }

    public String[] LoginWithPhone(final String phone, final String password){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");
        final DatabaseReference session = database.getReference("session");

        final String message[] = {"",""};
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                String phone = dataSnapshot.getValue(String.class);
                //do what you want with the email

                if(!dataSnapshot.hasChild(phone)){

                    message[0]="user khong ton tai";
                    message[1]="false";
                }else {
                    //check pass
                    String a = dataSnapshot.child(phone).child("password").getValue().toString();
                    if (a.equals(password)){
                        message[0]="dang nhap thanh cong";
                        message[1]="true";
                        //gan session
                        session.child(phone).setValue("true");
                        //luu gia tri
                    }else {
                        message[0]="sai mat khau";
                        message[1]="false";
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return message;
    }

    public String SignupWithPhone(Function<String,String> function){
        user a = new user(false);
        a = this;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");
        final DatabaseReference session = database.getReference("session");

//        check phone is duplicate
        final boolean status = true;

        DatabaseReference mostafa = session.child(a.phone);

        final user finalA = a;
        mostafa.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                String phone = dataSnapshot.getValue(String.class);
                //do what you want with the email

                if(!dataSnapshot.hasChild(finalA.getPhone())){

                    //----------gan thong tin dang kys cho sqlite----------------------

                    myRef.child(finalA.phone).setValue(finalA);
                    session.child(finalA.phone).setValue("true");
                    finalA.message = "Dang ky thanh cong";

                }else {
                    finalA.message = "Dang ky that bai";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return finalA.message;
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
