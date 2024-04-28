package com.example.myapplication.repositories;

import com.example.myapplication.models.UserModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UserRepository {

    public static UserModel createModel() {
        UserModel createdModel = new UserModel();
        createdModel.setName("Test Name");
        // Получаем текущую дату
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        // Вычитаем 20 лет из текущей даты
        calendar.add(Calendar.YEAR, -20);

        createdModel.setDob(calendar.getTime());
        return createdModel;
    }

    ArrayList<UserModel> users;

    protected UserRepository() {
        users = new ArrayList<UserModel>();
    }

    protected static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null){
            instance = new UserRepository();
        }
        return instance;
    }


}
