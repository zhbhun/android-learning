package com.zhbhun.tester.kotlin.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.zhbhun.tester.kotlin.databinding.CustomDialogFragmentBinding

class CustomDialogFragment : AppCompatDialogFragment() {
    private lateinit var binding: CustomDialogFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 使用自定义的布局文件来设置对话框的视图
        binding = CustomDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 设置按钮点击事件
        binding.buttonOk.setOnClickListener {
            Toast.makeText(requireContext(), "OK clicked", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }

    // 可以选择覆盖 onStart() 来设置对话框的样式
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    companion object {
        const val TAG = "CustomDialogFragment"

        // 创建实例方法
        fun newInstance(): CustomDialogFragment {
            return CustomDialogFragment()
        }
    }
}
