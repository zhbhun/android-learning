package com.zhbhun.tester.kotlin.ui.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhbhun.tester.kotlin.databinding.RelativeLayoutActivityBinding

class RelativeLayoutActivity : AppCompatActivity() {
 private lateinit var binding: RelativeLayoutActivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = RelativeLayoutActivityBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}
