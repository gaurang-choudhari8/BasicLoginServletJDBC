package com.basicLogin.model;
import java.util.regex.*;


public class User {
    private String name;
    private String phone;
    private String email;
    private String city;

    public User(String name, String phone, String email, String city) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(name.length()>=5){
        this.name = name;
        return true;
        }
        else return false;
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        Pattern pattern=Pattern.compile("[789][0-9]{9}");
        Matcher matcher=pattern.matcher(phone);
        if(matcher.matches()){
            this.phone=phone;
            return true;
        }
        else return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        Pattern pattern=Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z]+[.]com");
        Matcher matcher=pattern.matcher(email);
        if(matcher.matches()){
        this.email = email;
        return true;
        }
        else return false;
    }

    public String getCity() {
        return city;
    }

    public boolean setCity(String city) {
        this.city = city;
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
