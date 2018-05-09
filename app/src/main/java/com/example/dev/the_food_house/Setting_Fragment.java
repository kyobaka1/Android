package com.example.dev.the_food_house;

import android.annotation.SuppressLint;;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dev.the_food_house.model.user;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dev on 3/4/2018.
 */

public class Setting_Fragment extends AppCompatActivity {
    user loginUser;
    ListView lvMenu;
    ArrayList<MenuCaiDat> arrayMenu;
    menuCaiDatAdapter adapter;
    CircleImageView avarta;
    ImageView background;
    ImageView hidden;
    ImageView hiddenbg;
    Dialog dialog;
    public static final int PICK_PHOTO_FOR_AVATAR = 1;
    public static final int CAMERA_PHOTO_FOR_AVATAR = 2;
    public static final int PICK_PHOTO_FOR_BACKGROUND= 3;
    public static final int CAMERA_PHOTO_FOR_BACKGROUND = 4;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private DatabaseReference mDatabase;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_fragment_setting);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Viet.ttf");
        AnhXa();
        adapter = new menuCaiDatAdapter(this,R.layout.dnv_dong_menu_caidat, arrayMenu);
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i : Trả về vị trí người dùng đang click trên Listview.
                switch (i){
                    case 0: // Đổi hình đại diện
                        diglogAnhDaiDien();
                        break;
                    case 1: // Đổi back groud hình đại diện
                        dialogDoiPhongNen();
                        break;
                    case 2: // Hỗ trợ
                        Intent hotroIntent = new Intent(Setting_Fragment.this, Setting_Fragment_Hotro.class);
                        startActivity(hotroIntent);
                        break;
                    case 3: // Phương thức thanh toán
                        Intent thanhtoanIntent = new Intent(Setting_Fragment.this, Setting_Fragment_Thanhtoan.class);
                        startActivity(thanhtoanIntent);
                        break;
                    case 4: // Doi mat khau
                        Intent setupData = new Intent(Setting_Fragment.this, Setting_Setup_Database.class);
                        startActivity(setupData);
                        break;
                    case 5: // Gioi thieu.
                        Intent gioithieuIntent = new Intent(Setting_Fragment.this, Setting_Fragment_Gioithieu.class);
                        startActivity(gioithieuIntent);
                        break;
                    case 6: // Đăng xuất
                        break;
                }
            }
        });

    }
    private void AnhXa(){
        lvMenu = (ListView) findViewById(R.id.listview_menu);
        arrayMenu = new ArrayList<>();
        arrayMenu.add(new MenuCaiDat("Thay hình đại diện",R.drawable.avatar_icon));
        arrayMenu.add(new MenuCaiDat("Thay hình background đại diện",R.drawable.background_icon));
        arrayMenu.add(new MenuCaiDat("Các kênh hỗ trợ",R.drawable.support_icon));
        arrayMenu.add(new MenuCaiDat("Phương thức thanh toán",R.drawable.pay_icon));
        arrayMenu.add(new MenuCaiDat("Đổi mật khẩu",R.drawable.password_icon));
        arrayMenu.add(new MenuCaiDat("Giới thiệu về chuỗi cửa hàng",R.drawable.info_icon));
        arrayMenu.add(new MenuCaiDat("Đăng xuất",R.drawable.dangxuat_icon));
        avarta = (CircleImageView) findViewById(R.id.avarta_image);
        background = (ImageView) findViewById(R.id.avarta_background);
        hidden = (ImageView) findViewById(R.id.hidden_image);
        hiddenbg = (ImageView) findViewById(R.id.hidden_image_background);
        loginUser = new user(true);
        Picasso.get().load(loginUser.getAvatar()).into(avarta);
        Picasso.get().load(loginUser.getBackground()).into(background);
    }
    public void diglogAnhDaiDien(){
        final Dialog dialog=new Dialog( this );
        dialog.requestWindowFeature( Window.FEATURE_NO_TITLE );
        dialog.setContentView( R.layout.setting_selectavarta );
        LinearLayout folder=(LinearLayout) dialog.findViewById( R.id.folder_select );
        LinearLayout chupAnh=(LinearLayout) dialog.findViewById( R.id.camera_select );
        folder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_PHOTO_FOR_AVATAR);
            }
        } );
        chupAnh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent=new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult( intent,CAMERA_PHOTO_FOR_AVATAR );
            }
        } );
        dialog.show();
    }
    public void dialogDoiPhongNen(){
        final Dialog dialog=new Dialog( this );
        dialog.requestWindowFeature( Window.FEATURE_NO_TITLE );
        dialog.setContentView( R.layout.setting_selectavarta );
        LinearLayout folder=(LinearLayout) dialog.findViewById( R.id.folder_select );
        LinearLayout chupAnh=(LinearLayout) dialog.findViewById( R.id.camera_select );
        dialog.show();
        folder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_PHOTO_FOR_BACKGROUND);
            }
        } );
        chupAnh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent=new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult( intent,CAMERA_PHOTO_FOR_BACKGROUND );
            }
        } );

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== CAMERA_PHOTO_FOR_AVATAR&& resultCode==RESULT_OK && data!=null){
            Bitmap bitmap=(Bitmap) data.getExtras().get( "data" );
            hidden.setImageBitmap( bitmap );
            BitmapDrawable bitmapDrawable=(BitmapDrawable) hidden.getDrawable();
            Bitmap bitmap1=bitmapDrawable.getBitmap();
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(  );
            bitmap1.compress( Bitmap.CompressFormat.PNG,100,byteArrayOutputStream );
            byte [] hinh_anh=byteArrayOutputStream.toByteArray();
            //
            Calendar calendar=Calendar.getInstance();
            final StorageReference storageRef = storage.getReference();
            StorageReference mountainsRef = storageRef.child("hinh"+calendar.getTimeInMillis()+".png");
            hidden.setDrawingCacheEnabled(true);
            hidden.buildDrawingCache();
            bitmap= hidden.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] data1 = baos.toByteArray();

            UploadTask uploadTask = mountainsRef.putBytes(data1);// Gửi lên mảng byte.
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText( getApplication(),"Thay đổi không thành công!",Toast.LENGTH_SHORT ).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    Toast.makeText( getApplication(),"Thay đổi thành công!",Toast.LENGTH_SHORT ).show();
                    loginUser.setAvatar(String.valueOf(downloadUrl));
                    Picasso.get().load(downloadUrl).into(avarta);
                }
            });
        }
        if(requestCode == PICK_PHOTO_FOR_AVATAR && resultCode==RESULT_OK && data!=null){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream( uri );
                Bitmap bitmap= BitmapFactory.decodeStream( inputStream );
                hidden.setImageBitmap(bitmap);
                BitmapDrawable bitmapDrawable=(BitmapDrawable) hidden.getDrawable();
                Bitmap bitmap1=bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(  );
                bitmap1.compress( Bitmap.CompressFormat.PNG,100,byteArrayOutputStream );
                byte [] hinh_anh=byteArrayOutputStream.toByteArray();
                Calendar calendar=Calendar.getInstance();
                final StorageReference storageRef = storage.getReference();
                StorageReference mountainsRef = storageRef.child("hinh"+calendar.getTimeInMillis()+".png");
                hidden.setDrawingCacheEnabled(true);
                hidden.buildDrawingCache();
                bitmap= hidden.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data1 = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data1);//gui len mang byte
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText( getApplication(),"Thay đổi không thành công!",Toast.LENGTH_SHORT ).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText( getApplication(),"Thay đổi thành công!",Toast.LENGTH_SHORT ).show();
                        loginUser.setAvatar(String.valueOf(downloadUrl));
                        Picasso.get().load(downloadUrl).into(avarta);
                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(requestCode== CAMERA_PHOTO_FOR_BACKGROUND && resultCode==RESULT_OK && data!=null){
            Bitmap bitmap=(Bitmap) data.getExtras().get( "data" );
            hiddenbg.setImageBitmap( bitmap );
            BitmapDrawable bitmapDrawable=(BitmapDrawable) hiddenbg.getDrawable();
            Bitmap bitmap1=bitmapDrawable.getBitmap();
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(  );
            bitmap1.compress( Bitmap.CompressFormat.PNG,100,byteArrayOutputStream );
            byte [] hinh_anh=byteArrayOutputStream.toByteArray();
            //
            Calendar calendar=Calendar.getInstance();
            final StorageReference storageRef = storage.getReference();
            StorageReference mountainsRef = storageRef.child("hinh"+calendar.getTimeInMillis()+".png");
            hiddenbg.setDrawingCacheEnabled(true);
            hiddenbg.buildDrawingCache();
            bitmap= hiddenbg.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] data1 = baos.toByteArray();

            UploadTask uploadTask = mountainsRef.putBytes(data1);// Gửi lên mảng byte.
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText( getApplication(),"Thay đổi không thành công!",Toast.LENGTH_SHORT ).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    Toast.makeText( getApplication(),"Thay đổi thành công!",Toast.LENGTH_SHORT ).show();
                    loginUser.setBackground(String.valueOf(downloadUrl));
                    Picasso.get().load(downloadUrl).into(background);
                }
            });
        }
        if(requestCode == PICK_PHOTO_FOR_BACKGROUND && resultCode==RESULT_OK && data!=null){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream( uri );
                Bitmap bitmap= BitmapFactory.decodeStream( inputStream );
                hiddenbg.setImageBitmap( bitmap );
                BitmapDrawable bitmapDrawable=(BitmapDrawable) hiddenbg.getDrawable();
                Bitmap bitmap1=bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(  );
                bitmap1.compress( Bitmap.CompressFormat.PNG,100,byteArrayOutputStream );
                byte [] hinh_anh=byteArrayOutputStream.toByteArray();
                Calendar calendar=Calendar.getInstance();
                final StorageReference storageRef = storage.getReference();
                StorageReference mountainsRef = storageRef.child("hinh"+calendar.getTimeInMillis()+".png");
                hiddenbg.setDrawingCacheEnabled(true);
                hiddenbg.buildDrawingCache();
                bitmap= hiddenbg.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data1 = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data1);//gui len mang byte
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText( getApplication(),"Thay đổi không thành công!",Toast.LENGTH_SHORT ).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText( getApplication(),"Thay đổi thành công!",Toast.LENGTH_SHORT ).show();
                        loginUser.setBackground(String.valueOf(downloadUrl));
                        Picasso.get().load(downloadUrl).into(background);
                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult( requestCode, resultCode, data );
    }

}
