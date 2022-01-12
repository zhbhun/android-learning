package com.zhbhun.tester.android.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhbhun.tester.android.R;
import com.zhbhun.tester.android.ui.UIActivity;

public class ViewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_view_layout);

		Button baseBtn = this.findViewById(R.id.base);
		baseBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ViewActivity.this, BaseViewActivity.class);
				ViewActivity.this.startActivity(intent);
			}
		});

		Button customBtn = this.findViewById(R.id.custom);
		customBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ViewActivity.this, CustomViewActivity.class);
				ViewActivity.this.startActivity(intent);
			}
		});
	}
}
