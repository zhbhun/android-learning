package com.zhbhun.tester.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTesterActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tester_layout);

		Button lifecycleBtn = this.findViewById(R.id.lifecycle);
		lifecycleBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityTesterActivity.this, ActivityLifecycleActivity.class);
				ActivityTesterActivity.this.startActivity(intent);
			}
		});
	}
}
