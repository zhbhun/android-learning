package org.zhbhun.kmm2

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun createRootUIView(context: Any): Any {
    // 检查 context 是否为 Context 类型
    require(context is Context) { "Context must be an Android Context instance" }

    // 创建根视图
    val rootView = TextView(context).apply {
        text = "Hello from KMM on Android!"
        textSize = 24f
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }

    return rootView
}