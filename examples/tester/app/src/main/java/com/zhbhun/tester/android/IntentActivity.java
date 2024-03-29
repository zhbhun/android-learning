package com.zhbhun.tester.android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);

		Button way = this.findViewById(R.id.way);
		way.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IntentActivity.this, IntentWayActivity.class);
				IntentActivity.this.startActivity(intent);
			}
		});

        Button paramsTransfer = this.findViewById(R.id.paramsTransfer);
        paramsTransfer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IntentActivity.this, IntentParamsSenderActivity.class);
				IntentActivity.this.startActivity(intent);
			}
		});
    }
}
