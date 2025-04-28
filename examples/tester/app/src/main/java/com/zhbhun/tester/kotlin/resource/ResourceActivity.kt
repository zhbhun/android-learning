package com.zhbhun.tester.kotlin.resource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.ResourceActivityBinding

class ResourceActivity : AppCompatActivity() {
    private lateinit var binding: ResourceActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ResourceActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setTitle("Resource")
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView = binding.recyclerView
        val itemList = listOf(
            ListItem("ColorStateList", "") {
                startActivity(Intent(this@ResourceActivity, ColorStateListActivity::class.java))
            },
            ListItem("Drawable", "") {
                startActivity(Intent(this@ResourceActivity, DrawableActivity::class.java))
            },
            ListItem("AnimatedStateListDrawable", "") {
                startActivity(Intent(this@ResourceActivity, AnimatedStateListDrawableActivity::class.java))
            },
        )
        val adapter = ListItemAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
