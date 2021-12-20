package com.zhbhun.tester.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityLifecyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecyle_layout);

		Log.d("lifecycle", "onCreate");
    }

	@Override
	protected void onStart() {
		super.onStart();

		Log.d("lifecycle", "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.d("lifecycle", "onResume");
	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.d("lifecycle", "onStop");
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		Log.d("lifecycle", "onRestart");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.d("lifecycle", "onDestroy");
	}
}
