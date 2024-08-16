package com.zhbhun.tester.kotlin.ui.message

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zhbhun.tester.kotlin.MyApplication
import com.zhbhun.tester.kotlin.databinding.ToastActivityBinding

class ToastActivity : AppCompatActivity() {
    private lateinit var binding: ToastActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ToastActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.show.setOnClickListener() {
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        }

        binding.showWithGlobalContext.setOnClickListener() {
            Toast.makeText(MyApplication.context, "Hello World", Toast.LENGTH_SHORT).show()
        }
    }
}
