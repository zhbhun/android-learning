package com.zhbhun.examples.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_layout);

		Button intentBtn = this.findViewById(R.id.intent);
		intentBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, IntentActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});

		Button exit = this.findViewById(R.id.exit);
		exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		switch (item.getItemId()) {
			case R.id.addItem: {
				Toast.makeText(this, "You clicked Add", Toast.LENGTH_LONG).show();
				break;
			}
			case R.id.removeItem: {
				Toast.makeText(this, "You clicked Remove", Toast.LENGTH_LONG).show();
			}
		}
		return true;
	}
}
