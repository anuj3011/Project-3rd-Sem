package com.example.accord.Models;

public class ServiceProvider {

    //class defined for Service provider registeration purposes.

    private String first_name;
    private String last_name;

    private int Age;
    private long Phone;

    private String Address;
    private String email;
    private String profession;
    private String password;
    public String type="sp";
    public ServiceProvider ()
    // Default constructor required for calls to DataSnapshot.getValue(User.class)
    {
    }

    public ServiceProvider (String first_name, String last_name, int Age, long Phone, String Address, String email, String profession, String password)
    {
       //
    }
    public String getType(){
        return type;
    }
    public String getfirst_name()
    {
        return first_name;
    }

    public String getlast_name()
    {
        return last_name;
    }

    public int getAge()
    {
        return Age;
    }

    public long getPhone()
    {
        return Phone;
    }

    public String getAddress()
    {
        return Address;
    }

    public String getemail()
    {
        return email;
    }

    public String getprofession()
    {
        return profession;
    }

    public String getpassword()
    {
        return password;
    }

}