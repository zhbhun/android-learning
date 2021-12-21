package com.zhbhun.tester.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityLifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecyle_layout);

		Log.d("lifecycle", "onCreate");

		Button normalBtn = this.findViewById(R.id.normal);
		normalBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLifecycleActivity.this, ActivityLifecycleNormalActivity.class);
				ActivityLifecycleActivity.this.startActivity(intent);
			}
		});

		Button dialogBtn = this.findViewById(R.id.dialog);
		dialogBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLifecycleActivity.this, ActivityLifecycleDialogActivity.class);
				ActivityLifecycleActivity.this.startActivity(intent);
			}
		});
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
	protected void onPause() {
		super.onPause();

		Log.d("lifecycle", "onPause");
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

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);

		Log.d("lifecycle", "onSaveInstanceState");
	}
}
