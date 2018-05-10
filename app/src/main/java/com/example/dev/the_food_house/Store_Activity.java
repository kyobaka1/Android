package com.example.dev.the_food_house;

/**
 * Created by thanh on 3/24/2018.
 */

public class Store_Activity {
    private String Name;
    private String Address;
    private Double Latitude;
    private Double Longitude;
    private int Phone;
    private Double distance;
    private String image;
    private String quan;



    public Store_Activity(String Name, String Address, Double Latitude, Double Longtitude, int Phone,String image,String quan) {
        this.Name = Name;
        this.Address = Address;
        this.Latitude = Latitude;
        this.Longitude=Longtitude;
        this.Phone=Phone;
        this.image=image;
        this.quan=quan;
    }
    public Store_Activity()
    {

    }

    public void setName(String Name)
    {
        this.Name=Name;
    }

    public void setimage(String image)
    {
        this.image=image;
    }
    public void setquan(String image)
    {
        this.quan=quan;
    }


    public void setAddress(String Address)
    {
        this.Address=Address;
    }
    public void setLatitude(Double Latitude)
    {
        this.Latitude=Latitude;
    }
    public void setLongtitude(Double Longtitude)
    {
        this.Longitude=Longtitude;
    }

    public String getName() {
        return Name;
    }

    public String getimage() {
        return image;
    }

    public String getquan() {
        return quan;
    }

    public String getAddress() {
        return Address;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }
    public int getPhone() {
        return Phone;
    }

    public void setDistance(Double Distance)
    {
        this.distance=Distance;
    }
    public Double getDistance()
    {
        return distance;
    }



}
