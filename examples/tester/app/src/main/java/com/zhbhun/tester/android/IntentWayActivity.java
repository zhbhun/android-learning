package com.zhbhun.tester.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentWayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_way_layout);

		Button explicit = this.findViewById(R.id.explicit);
		explicit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IntentWayActivity.this, IntentWayActivity.class);
				IntentWayActivity.this.startActivity(intent);
			}
		});

		Button implicit = this.findViewById(R.id.implicit);
		implicit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("com.zhbhun.tester.android.INTENT_WAY");
				intent.addCategory("android.intent.category.DEFAULT");
				intent.addCategory("android.intent.category.INTENT_WAY");
				IntentWayActivity.this.startActivity(intent);
			}
		});

		Button implicitOfName = this.findViewById(R.id.implicitOfName);
		implicitOfName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("com.zhbhun.tester.android.INTENT_WAY");
				IntentWayActivity.this.startActivity(intent);
			}
		});

		Button implicitOfErrorName = this.findViewById(R.id.implicitOfErrorName);
		implicitOfErrorName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("com.zhbhun.tester.android.INTENT_WAY1");
				IntentWayActivity.this.startActivity(intent);
			}
		});

		Button implicitOfURL = this.findViewById(R.id.implicitOfURL);
		implicitOfURL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.baidu.com"));
				IntentWayActivity.this.startActivity(intent);
			}
		});

		Button implicitOfCustomURL = this.findViewById(R.id.implicitOfCustomURL);
		implicitOfCustomURL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("zhbhun://www.baidu.com"));
				IntentWayActivity.this.startActivity(intent);
			}
		});
    }
}
