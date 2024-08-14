package com.zhbhun.tester.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val recyclerView = binding.recyclerView
    val itemList = listOf(
      ListItem("Item 1", "Description 1") {},
      ListItem("Item 2", "Description 2") {},
      ListItem("Item 3", "Description 3") {},
    )
    val adapter = ListItemAdapter(itemList)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)
  }
}
