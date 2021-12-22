package com.zhbhun.tester.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityLaunchModeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch_mode_layout);

		Log.d("launchMode", this.getTaskId() + " - " + this.toString());

		Button standardBtn = this.findViewById(R.id.standard);
		standardBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLaunchModeActivity.this, ActivityLaunchModeStandardActivity.class);
				ActivityLaunchModeActivity.this.startActivity(intent);
			}
		});

		Button singleTopBtn = this.findViewById(R.id.singleTop);
		singleTopBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLaunchModeActivity.this, ActivityLaunchModeSingleTopActivity.class);
				ActivityLaunchModeActivity.this.startActivity(intent);
			}
		});

		Button singleTaskBtn = this.findViewById(R.id.singleTask);
		singleTaskBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLaunchModeActivity.this, ActivityLaunchModeSingleTaskActivity.class);
				ActivityLaunchModeActivity.this.startActivity(intent);
			}
		});

		Button singleInstancceBtn = this.findViewById(R.id.singleInstance);
		singleInstancceBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLaunchModeActivity.this, ActivityLaunchModeSingleInstanceActivity.class);
				ActivityLaunchModeActivity.this.startActivity(intent);
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

		Log.d("launchMode", this.getTaskId() + " - " + this.toString() + " destroy");
	}
}
