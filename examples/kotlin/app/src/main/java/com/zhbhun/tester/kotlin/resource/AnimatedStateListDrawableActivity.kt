package com.zhbhun.tester.kotlin.resource

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat
import com.zhbhun.tester.kotlin.R
import com.zhbhun.tester.kotlin.databinding.AnimatedStateListDrawableResourceActivityBinding

class AnimatedStateListDrawableActivity : AppCompatActivity() {
    private lateinit var binding: AnimatedStateListDrawableResourceActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AnimatedStateListDrawableResourceActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageView = binding.imageView
        val animatedStateListDrawableCompat = AnimatedStateListDrawableCompat.create(
            this,
            R.drawable.animated_button,
            null
        )
        imageView.setImageDrawable(animatedStateListDrawableCompat)
        imageView.isClickable = true
    }
}
