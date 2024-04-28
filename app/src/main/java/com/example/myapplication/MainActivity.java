package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public void showToast(String message) {
        Toast.makeText( this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Вызвать метод предка
        super.onCreate(savedInstanceState);

        //
        // EdgeToEdge.enable(this);

        // Назначить версту для этого экрана
        // setContentView(R.layout.activity_main);
        // setContentView(R.layout.activity_main_code_create);

        // Создадим верстку програмно
        createElementsInConstraintLayout();

        Log.i("MyTag", "onCreateWork");

        showToast("Hello Toast");
    }

    /**
     * Создание элементов программным способом
     */
    protected void createElementsInConstraintLayout() {

        // Создаем контейнер нужного мне типа
        ConstraintLayout layout = new ConstraintLayout(this);

        // СОздаем нужный мне эелемень
        Button btn = new Button(this);
        btn.setText("Button");

        // Передаю правила поведения внутри контейнера
        btn.setLayoutParams( new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        ));

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((MainActivity) v.getContext()).showToast(" Click ");
//            }
//        });

        // Описание событий чаще удобно делать в отдельном объекте (файле)
        btn.setOnClickListener( new ButtonClickListener());

        // Нет гарании верного отображения - если я передаю другой типа параметров контейнера
        // Причем это не ошибка - это warning
//        btn.setLayoutParams( new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ConstraintLayout.LayoutParams.WRAP_CONTENT
//        ));

        // Добавить в мой контейнер вновь созданный элемент
        layout.addView(btn);

        // Назначить мою верстку с собранными элементами - как главную верстку
        setContentView(layout);
    }
}