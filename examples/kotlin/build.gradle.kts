plugins {
  kotlin("jvm") version "2.1.20"
}

group = "com.zhbhun.kotlin"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(17)
}
