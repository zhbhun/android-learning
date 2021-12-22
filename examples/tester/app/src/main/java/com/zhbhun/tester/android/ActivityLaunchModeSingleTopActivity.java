package com.zhbhun.tester.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityLaunchModeSingleTopActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch_mode_single_top_layout);

		Log.d("launchMode", this.getTaskId() + " - " + this.toString());

		Button indexBtn = this.findViewById(R.id.index);
		indexBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLaunchModeSingleTopActivity.this, ActivityLaunchModeActivity.class);
				ActivityLaunchModeSingleTopActivity.this.startActivity(intent);
			}
		});

		Button singleTopBtn = this.findViewById(R.id.singleTop);
		singleTopBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLaunchModeSingleTopActivity.this, ActivityLaunchModeSingleTopActivity.class);
				ActivityLaunchModeSingleTopActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		Log.d("launchMode", this.getTaskId() + " - " + this.toString() + " restart");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.d("launchMode", this.getTaskId() + " - " + this.toString() + " destroyed");
	}
}
