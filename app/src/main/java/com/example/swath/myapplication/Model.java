package com.example.swath.myapplication;

import java.io.Serializable;

public class Model implements Serializable {

    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPhone() {
        return phone;
    }

    public String getMsg() {
        return msg;
    }

    private String msg;

}
