package com.zhbhun.tester.android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IntentParamsSenderActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_params_sender_layout);

		Button sender = this.findViewById(R.id.send);
		sender.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IntentParamsSenderActivity.this, IntendParamsReceiverActivity.class);
				intent.putExtra("byte", 1);
				intent.putExtra("int", 1);
				intent.putExtra("char", 'a');
				intent.putExtra("long", 1L);
				intent.putExtra("float", 1.1F);
				intent.putExtra("double", 1.1D);
				intent.putExtra("boolean", true);
				intent.putExtra("string", "abc");
				IntentParamsSenderActivity.this.startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
			case 1: {
				if (resultCode == RESULT_OK) {
					String returnedData = data.getStringExtra("data_return");
					Log.d("IntentParams", "RESULT_OK: " + returnedData);
				} else if (resultCode == RESULT_CANCELED) {
					String returnedData = data.getStringExtra("data_return");
					Log.d("IntentParams", "RESULT_CANCELED: " + returnedData);
				}
			}
			default:
		}
	}
}
