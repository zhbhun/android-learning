package com.zhbhun.tester.kotlin.ui.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhbhun.tester.kotlin.databinding.ConstraintLayoutActivityBinding

class ConstraintLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ConstraintLayoutActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ConstraintLayoutActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
