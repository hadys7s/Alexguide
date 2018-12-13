package com.example.android.alextourguide;


import android.provider.MediaStore;

public class Name {

    private String EName;
    private String Address;
    private int images;
    public String Gps;
   // private String time;




    public Name(String name,String address,int img,String gps)
    {
        EName=name;
        Address=address;
        images=img;
        Gps=gps;



    }
    public Name(String name,String address,int img)
    {
        EName=name;
        Address=address;
        images=img;



    }
    public Name (){

    }

    public String getName() {
        return EName;
    }

    public int getImages() {
        return images;
    }

    public String getAddress() {
        return Address;
    }

    public String getGps() { return Gps;}
}
