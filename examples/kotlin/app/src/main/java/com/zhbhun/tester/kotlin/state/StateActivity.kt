package com.zhbhun.tester.kotlin.state

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.StateActivityBinding

class StateActivity : AppCompatActivity() {

    private lateinit var binding: StateActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = StateActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val itemList = listOf(
            ListItem("ViewModel", "") {
                startActivity(Intent(this@StateActivity, ViewModelActivity::class.java))
            },
            ListItem("...", "") {},
        )
        val adapter = ListItemAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
