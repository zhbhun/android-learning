package com.zhbhun.tester.kotlin.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.UiActivityBinding
import com.zhbhun.tester.kotlin.ui.dialog.DialogActivity
import com.zhbhun.tester.kotlin.ui.layout.LayoutActivity
import com.zhbhun.tester.kotlin.ui.message.MessageActivity

class UIActivity : AppCompatActivity() {
    private lateinit var binding: UiActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UiActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val itemList = listOf(
            ListItem("Layout", "") {
                startActivity(Intent(this@UIActivity, LayoutActivity::class.java))
            },
            ListItem("Message", "") {
                startActivity(Intent(this@UIActivity, MessageActivity::class.java))
            },
            ListItem("Dialog", "") {
                startActivity(Intent(this@UIActivity, DialogActivity::class.java))
            },
            ListItem("...", "") {},
        )
        val adapter = ListItemAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
