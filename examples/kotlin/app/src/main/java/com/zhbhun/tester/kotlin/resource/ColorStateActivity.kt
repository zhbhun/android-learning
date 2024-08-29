package com.zhbhun.tester.kotlin.resource

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.zhbhun.tester.kotlin.R
import com.zhbhun.tester.kotlin.databinding.ColorStateActivityBinding

class ColorStateActivity: AppCompatActivity() {
    private lateinit var binding: ColorStateActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ColorStateActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView = binding.textView
        val textColors = AppCompatResources.getColorStateList(this, R.color.selector_text)
        textView.isClickable = true;
        textView.setTextColor(textColors)
    }
}
