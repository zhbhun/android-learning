package org.zhbhun.kmm2

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun loadView(context: Any): Any {
        return createRootUIView(context)
    }
}