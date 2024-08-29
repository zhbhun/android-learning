package com.zhbhun.tester.kotlin.resource

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.zhbhun.tester.kotlin.R
import com.zhbhun.tester.kotlin.databinding.ColorStateActivityBinding
import com.zhbhun.tester.kotlin.databinding.DrawableResourceActivityBinding

class DrawableActivity : AppCompatActivity() {
    private lateinit var binding: DrawableResourceActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DrawableResourceActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageView = binding.imageView
        val drawable = AppCompatResources.getDrawable(this, R.drawable.ic_launcher_foreground)
        imageView.setImageDrawable(drawable)
    }
}
