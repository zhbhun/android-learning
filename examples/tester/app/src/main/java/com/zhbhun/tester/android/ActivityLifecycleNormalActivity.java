package com.zhbhun.tester.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityLifecycleNormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_normal_layout);
    }
}
