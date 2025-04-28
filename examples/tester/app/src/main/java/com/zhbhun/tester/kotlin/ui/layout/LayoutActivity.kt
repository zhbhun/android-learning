package com.zhbhun.tester.kotlin.ui.layout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.LayoutActivityBinding

class LayoutActivity : AppCompatActivity() {
 private lateinit var binding: LayoutActivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = LayoutActivityBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val recyclerView = binding.recyclerView
    val itemList = listOf(
      ListItem("LinearLayout", "") {
        startActivity(Intent(this@LayoutActivity, LinearLayoutActivity::class.java))
      },
      ListItem("FrameLayout", "") {
        startActivity(Intent(this@LayoutActivity, FrameLayoutActivity::class.java))
      },
      ListItem("FrameLayout", "") {
        startActivity(Intent(this@LayoutActivity, FrameLayoutActivity::class.java))
      },
      ListItem("RelativeLayout", "") {
        startActivity(Intent(this@LayoutActivity, RelativeLayoutActivity::class.java))
      },
      ListItem("ConstraintLayout", "") {
        startActivity(Intent(this@LayoutActivity, ConstraintLayoutActivity::class.java))
      },
      ListItem("...", "") {},
    )
    val adapter = ListItemAdapter(itemList)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)
  }
}
