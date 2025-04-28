package com.zhbhun.tester.kotlin.ui.message

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.MessageActivityBinding
import com.zhbhun.tester.kotlin.ui.layout.LayoutActivity

class MessageActivity : AppCompatActivity() {
    private lateinit var binding: MessageActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MessageActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val itemList = listOf(
            ListItem("Toast", "") {
                startActivity(Intent(this@MessageActivity, ToastActivity::class.java))
            },
            ListItem("...", "") {},
        )
        val adapter = ListItemAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
