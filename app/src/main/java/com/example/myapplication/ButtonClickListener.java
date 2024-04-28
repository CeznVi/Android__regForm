package com.example.myapplication;

import android.view.View;

public class ButtonClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        ((MainActivity) v.getContext()).showToast(" Click ");
    }
}
