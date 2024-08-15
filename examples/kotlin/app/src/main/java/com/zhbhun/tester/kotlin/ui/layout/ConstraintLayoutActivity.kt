package com.zhbhun.tester.kotlin.ui.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhbhun.tester.kotlin.databinding.FrameLayoutActivityBinding

class ConstraintLayoutActivity : AppCompatActivity() {
 private lateinit var binding: FrameLayoutActivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = FrameLayoutActivityBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}
