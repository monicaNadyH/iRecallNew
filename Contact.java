package com.irecallapp.main;

import android.app.Activity;

/**
 * Created by Research Admin on 12/26/2015.
 */
public class Contact extends Activity{
    int id, id2;
    String name, email, uname, pass, Role;
    String role;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return this.id;
    }

    public void setRole(String Role)
    {
        this.Role = Role;
    }

    public String getRole()
    {
        return this.Role;
    }



    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }


    public void setUname(String uname)
    {
        this.uname = uname;
    }

    public String getUname()
    {
        return this.uname;
    }


    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPass()
    {
        return this.pass;
    }

}
