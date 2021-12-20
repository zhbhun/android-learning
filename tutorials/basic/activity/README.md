# Activity

## 跳转/Intent

- 启动活动
- 启动服务
- 发送广播

### 方式

- 显式
- 隐式：

    - action + cateogry
    - data

示例：

- `AndroidManifest.xml`

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.zhbhun.examples.activitytest">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/Theme.ActivityTest">
            <activity
                android:name=".IntentWayActivity"
                android:label="跳转方式"
                android:exported="false">
                <intent-filter>
                    <action android:name="com.zhbhun.examples.activitytest.INTENT_WAY" />
                    <category android:name="android.intent.category.DEFAULT" />
                    <category android:name="android.intent.category.INTENT_WAY" />
                    <data android:scheme="zhbhun" />
                </intent-filter>
            </activity>
        </application>
    </manifest>
    ```

- `IntentWayActivity`

    ```java
    package com.zhbhun.examples.activitytest;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
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
                    Intent intent = new Intent("com.zhbhun.examples.activitytest.INTENT_WAY");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.addCategory("android.intent.category.INTENT_WAY");
                    IntentWayActivity.this.startActivity(intent);
                }
            });

            Button implicitOfName = this.findViewById(R.id.implicitOfName);
            implicitOfName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("com.zhbhun.examples.activitytest.INTENT_WAY");
                    IntentWayActivity.this.startActivity(intent);
                }
            });


            Button implicitOfErrorName = this.findViewById(R.id.implicitOfErrorName);
            implicitOfErrorName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("com.zhbhun.examples.activitytest.INTENT_WAY1");
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
    ```

### 传参

- 发送信息：`intent.putExtra`
- 接收信息：

    - `startActivityForResult` + `onActivityResult`
    - ...


示例

- `AndroidManifest.xml`

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.zhbhun.examples.activitytest">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/Theme.ActivityTest">
            <activity
                android:name=".IntentParamsSenderActivity"
                android:label="传参发送者"
                android:exported="false" />
            <activity
                android:name=".IntendParamsReceiverActivity"
                android:label="传参接收者"
                android:exported="false" />
        </application>

    </manifest>

    ```

- `IntentParamsSenderActivity.java`

    ```java
    package com.zhbhun.examples.activitytest;

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
    ```

- `IntendParamsReceiverActivity.java`

    ```java
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
    ```

