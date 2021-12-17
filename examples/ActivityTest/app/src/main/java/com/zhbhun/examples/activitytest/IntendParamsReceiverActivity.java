package com.zhbhun.examples.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IntendParamsReceiverActivity extends AppCompatActivity {

	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello by back");
		this.setResult(RESULT_CANCELED, intent);
		this.finish();
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intend_params_receiver_layout);

		Intent intent = this.getIntent();
		Log.d("IntentParams", "receive: " + intent.getStringExtra("string"));

		Button finishButton = this.findViewById(R.id.finish);
		finishButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello by finish");
				IntendParamsReceiverActivity.this.setResult(IntendParamsReceiverActivity.RESULT_OK, intent);
				IntendParamsReceiverActivity.this.finish();
			}
		});
    }
}
