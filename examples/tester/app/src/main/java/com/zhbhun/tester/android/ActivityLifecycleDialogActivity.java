package com.zhbhun.tester.android;

import android.app.Activity;
import android.os.Bundle;

public class ActivityLifecycleDialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_dialog_layout);
    }
}
