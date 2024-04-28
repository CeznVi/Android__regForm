package com.example.myapplication.models;

import com.example.myapplication.enums.UserSexEnum;
import com.example.myapplication.viewmodels.OnModelChange;

import java.util.Date;
import java.util.UUID;

public class UserModel {

    private OnModelChange viewModel;

    private void sendNotification() {
        if(viewModel != null)
            viewModel.onModelChange();
    }

    public void setViewModel(OnModelChange viewModel) {
        this.viewModel = viewModel;
    }

    public UserModel() {
        id = UUID.randomUUID();
    }

    private UUID id;

    private String name;

    private Date dob;

    private String email;

    private UserSexEnum sex;

    private String phone;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
        sendNotification();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        sendNotification();
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
        sendNotification();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        sendNotification();
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
        sendNotification();
    }

    public void setName(String name) {
        this.name = name;
        sendNotification();
    }

    public String getName() {
        return name;
    }
}
