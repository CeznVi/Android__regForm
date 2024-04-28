package com.example.myapplication.views;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.models.UserModel;
import com.example.myapplication.repositories.UserRepository;
import com.example.myapplication.viewmodels.UserViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class UserActivity extends AppCompatActivity {

    public void showToast(String message) {
        Toast.makeText( this, message, Toast.LENGTH_LONG).show();
    }

    public void showToast (int rId) {
        // Получаем текст из строки ресурса
        String toastMessage = getResources().getString(rId);

// Выводим сообщение
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }

    public UserActivity() {
        super();
    }

    UserModel userModel;
    UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);

        userModel = UserRepository.createModel();
        userViewModel = new UserViewModel(this, userModel);
        // userViewModel.setWayToModel();
        userViewModel.toView();
        userViewModel.setWayToModel();
    }

    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Обработка выбранной даты
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                ( (TextInputEditText) findViewById(R.id.user_dob)).setText(selectedDate);
            }
        }, 2000, 0, 1); // Начальная дата
        datePickerDialog.show();
    }

    public void clearUser(View view) {
        this.userModel.setName("User Name");
    }
}