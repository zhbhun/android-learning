package com.zhbhun.tester.android.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhbhun.tester.android.R;
import com.zhbhun.tester.android.ui.view.ViewActivity;

public class UIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_layout);

		Button viewBtn = this.findViewById(R.id.view);
		viewBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(UIActivity.this, ViewActivity.class);
				UIActivity.this.startActivity(intent);
			}
		});

	}
}
