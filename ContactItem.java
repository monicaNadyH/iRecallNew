package com.irecallapp.main;

/**
 * Created by Macintosh on 1/10/16.
 */
public class ContactItem {

    public String id;
    public String contactName;
    public String phoneNumber;

    public ContactItem (String id, String name, String phone){

        this.id = id;
        this.contactName = name;
        this.phoneNumber = phone;
    }
}
