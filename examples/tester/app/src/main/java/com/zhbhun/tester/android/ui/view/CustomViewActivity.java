package com.zhbhun.tester.android.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zhbhun.tester.android.R;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_custom_view_layout);
    }
}
