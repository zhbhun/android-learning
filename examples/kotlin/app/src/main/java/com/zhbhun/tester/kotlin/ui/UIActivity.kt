package com.zhbhun.tester.kotlin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.UiActivityBinding
import com.zhbhun.tester.kotlin.ui.layout.LayoutActivity

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
      ListItem("...", "") {},
    )
    val adapter = ListItemAdapter(itemList)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)
  }
}
