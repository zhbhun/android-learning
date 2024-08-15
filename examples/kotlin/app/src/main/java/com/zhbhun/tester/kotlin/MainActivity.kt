package com.zhbhun.tester.kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.databinding.ActivityMainBinding
import com.zhbhun.tester.kotlin.state.StateActivity
import com.zhbhun.tester.kotlin.ui.UIActivity

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val recyclerView = binding.recyclerView
    val itemList = listOf(
      ListItem("UI", "") {
        startActivity(Intent(this@MainActivity, UIActivity::class.java))
      },
      ListItem("State", "") {
        startActivity(Intent(this@MainActivity, StateActivity::class.java))
      },
      ListItem("Item 3", "") {},
    )
    val adapter = ListItemAdapter(itemList)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)
  }
}
