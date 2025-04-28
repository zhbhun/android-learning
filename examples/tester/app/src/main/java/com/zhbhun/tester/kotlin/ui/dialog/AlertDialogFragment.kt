package com.zhbhun.tester.kotlin.ui.dialog

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment

class AlertDialogFragment : AppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("示例对话框")
            .setMessage("这是一个示例对话框，您要继续吗？")
            .setPositiveButton("确定") { dialog, _ ->
                // 处理确定按钮的点击事件
                dialog.dismiss()
            }
            .setNegativeButton("取消") { dialog, _ ->
                // 处理取消按钮的点击事件
                dialog.dismiss()
            }
            .create()
    }

    companion object {
        const val TAG = "AlertDialogFragment"

        // 创建实例方法
        fun newInstance(): AlertDialogFragment {
            return AlertDialogFragment()
        }
    }
}
