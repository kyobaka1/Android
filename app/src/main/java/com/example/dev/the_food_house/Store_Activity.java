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
    public Store_Activity(String Name, String Address, Double Latitude, Double Longtitude, int Phone) {
        this.Name = Name;
        this.Address = Address;
        this.Latitude = Latitude;
        this.Longitude=Longtitude;
        this.Phone=Phone;
    }
    public Store_Activity()
    {

    }

    public void setName(String Name)
    {
        this.Name=Name;
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
