package com.zhbhun.tester.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityLaunchModeStandardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_standard_layout);

		Log.d("launchMode", this.getTaskId() + " - " + this.toString());

		Button indexBtn = this.findViewById(R.id.index);
		indexBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityLaunchModeStandardActivity.this, ActivityLaunchModeActivity.class);
				ActivityLaunchModeStandardActivity.this.startActivity(intent);
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
