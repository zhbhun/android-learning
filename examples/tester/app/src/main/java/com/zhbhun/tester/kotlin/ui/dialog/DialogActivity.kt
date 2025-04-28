package com.zhbhun.tester.kotlin.ui.dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhbhun.tester.kotlin.ListItem
import com.zhbhun.tester.kotlin.ListItemAdapter
import com.zhbhun.tester.kotlin.databinding.DialogActivityBinding

class DialogActivity : AppCompatActivity() {
    private lateinit var binding: DialogActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val itemList = listOf(
            ListItem("Alert", "") {
                val dialog = AlertDialogFragment.newInstance()
                dialog.show(supportFragmentManager, AlertDialogFragment.TAG)
            },
            ListItem("Custom", "") {
                val dialog = CustomDialogFragment.newInstance()
                dialog.show(supportFragmentManager, CustomDialogFragment.TAG)
            },
            ListItem("...", "") {},
        )
        val adapter = ListItemAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
