package org.zhbhun.kmm2

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSSelectorFromString
import platform.UIKit.NSLayoutConstraint
import platform.UIKit.UIButton
import platform.UIKit.UIColor
import platform.UIKit.UIControlEventTouchUpInside
import platform.UIKit.UIControlStateNormal
import platform.UIKit.UIDevice
import platform.UIKit.UIView


class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

class ButtonHandler() {
    var count = 0
    lateinit var button: UIButton

    // 设置按钮并更新标题的函数
    fun setButton(button: UIButton) {
        this.button = button
        this.button.setTitle("$count", forState = UIControlStateNormal)
    }

    // 按钮点击事件的处理方法，必须使用 @ObjCAction
    @ObjCAction
    fun buttonTapped() {
        count += 1
        button.setTitle("$count", forState = UIControlStateNormal)
    }
}


@OptIn(ExperimentalForeignApi::class)
actual fun createRootUIView(context: Any): Any {
    val container = UIView()
    container.translatesAutoresizingMaskIntoConstraints = false

    val button = UIButton()
    button.translatesAutoresizingMaskIntoConstraints = false
    button.backgroundColor = UIColor.grayColor

    val handler = ButtonHandler()
    handler.setButton(button) // 设置按钮实例
    button.addTarget(
        target = handler,
        action = NSSelectorFromString("buttonTapped"),
        forControlEvents = UIControlEventTouchUpInside
    )

    container.addSubview(button)
    NSLayoutConstraint.activateConstraints(listOf(
        button.centerXAnchor.constraintEqualToAnchor(container.centerXAnchor),
        button.centerYAnchor.constraintEqualToAnchor(container.centerYAnchor),
        button.widthAnchor.constraintEqualToConstant(100.0),
        button.heightAnchor.constraintEqualToConstant(100.0),
    ))
    return container
}

