package com.example.myapplication.viewmodels;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.R;
import com.example.myapplication.enums.UserSexEnum;
import com.example.myapplication.models.UserModel;
import com.example.myapplication.views.UserActivity;

public class UserViewModel implements OnModelChange {

    UserActivity activity;
    UserModel currentUser;

    public UserViewModel(UserActivity activity, UserModel model) {
        this.handler = new Handler();

        this.activity = activity;
        this.currentUser = model;
        this.currentUser.setViewModel(this);
    }



    View findViewById(int id) {
        return activity.findViewById(id);
    }

    public void setWayToModel() {

        ((EditText) findViewById(R.id.user_name)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isUserInput = true; // отключить обновление формы при обновлении данных модели
                currentUser.setName(s.toString());
                isUserInput = false; // включить обновление формы
                activity.showToast("Name Change");            }
        });
    }

    private  boolean isUserInput = false;





    public void toView() {
        ((EditText) findViewById(R.id.user_name)).setText(currentUser.getName());
        ((EditText) findViewById(R.id.user_phone)).setText(currentUser.getPhone());
        ((EditText) findViewById(R.id.user_email)).setText(currentUser.getEmail());

        // Вот тут настроить вывод данных
        ((EditText) findViewById(R.id.user_dob)).setText(currentUser.getDob().toLocaleString());

        if(currentUser.getSex() == UserSexEnum.male) {
            ((RadioButton) findViewById(R.id.user_sex_male)).setChecked(true);
        }
        if(currentUser.getSex() == UserSexEnum.female) {
            ((RadioButton) findViewById(R.id.user_sex_female)).setChecked(true);
        }
    }




    public void fromView() {
        currentUser.setName(((EditText) findViewById(R.id.user_name)).getText().toString());
        currentUser.setPhone(((EditText) findViewById(R.id.user_phone)).getText().toString());
        currentUser.setEmail(((EditText) findViewById(R.id.user_email)).getText().toString());

        // Находим RadioGroup по его идентификатору
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.user_sex_group);
        // Получаем идентификатор выбранной RadioButton
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.user_sex_male) {
            currentUser.setSex(UserSexEnum.male);
        } else if (selectedId == R.id.user_sex_female) {
            currentUser.setSex(UserSexEnum.female);
        } else {
            activity.showToast(R.string.user_toast_select_sex);
        }
    }

    private Handler handler;


    @Override
    public void onModelChange() {
        if(!isUserInput)
            this.toView();
        activity.showToast("Change View");
    }
}
