package com.zhbhun.tester.kotlin.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.ActivityActivityBinding

class ActivityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val itemList = listOf(
            ListItem("LifecycleObserver", "") {
                startActivity(Intent(this@ActivityActivity, LifecycleObserverActivity::class.java))
            },
            ListItem("...", "") {},
        )
        val adapter = ListItemAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
