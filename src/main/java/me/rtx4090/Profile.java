package me.rtx4090;

import java.io.File;
import java.io.Serializable;


public class Profile {
    private String name;
    private String id;
    private String address;
    private String number;
    private String email;

    public Profile(String name, String id, String address, String number, String email) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }


}
