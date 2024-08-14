package com.zhbhun.tester.kotlin.ui.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhbhun.tester.kotlin.databinding.LinearLayoutActivityBinding

class LinearLayoutActivity : AppCompatActivity() {
 private lateinit var binding: LinearLayoutActivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = LinearLayoutActivityBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}
