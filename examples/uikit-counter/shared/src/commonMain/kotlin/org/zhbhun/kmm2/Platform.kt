package org.zhbhun.kmm2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun createRootUIView(context: Any): Any