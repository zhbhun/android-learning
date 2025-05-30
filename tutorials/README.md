# 介绍

- [Developer guides](https://developer.android.com/guide)
- [Android Views and Widgets Samples Repository](git@github.com:android/views-widgets-samples.git)

## 系统架构/四层架构

- Linux 内核层：硬件驱动
- 系统运行库：OpenGL/ES、SQLLite、Webkit、Dalvik/ART
- 应用架构层
- 应用层

## 系统版本

- 版本号
- 系统代号
- API

参考 

- [平台代号、版本、API 级别和 NDK 版本](https://source.android.google.cn/setup/start/build-numbers?hl=zh-cn#platform-code-names-versions-api-levels-and-ndk-releases)
- [【Android】系统版本代号一览](https://segmentfault.com/a/1190000039868272)

## 四大组件

- Activity：活动
- Service：服务
- BroadcastReceiver：广播接收器
- ContentProvider：内容提供器

## 开发工具

- JDK：Java 语言的软件开发工具包，包含 Java 运行环境、工具集合和基础类库等

    ps：可以使用 [jabba](https://github.com/shyiko/jabba) 安装

- Android SDK：Google 提供的 Android 开发工具包
- Android Studio：Google 提供的 Android 开发 IDE

## 项目结构

文件视图

```
.
├── .gradle ################################################ gradle 生成
├── .idea ################################################## IDE 生成
├── app #################################################### 应用模块
│   ├── build ############################################## 编译生成目录
│   ├── libs ############################################### 第三方 jar 包
│   ├── src ################################################ 源代码
│   │   ├── androidTest #################################### 自动化测试用例
│   │   ├── main ########################################### 主目录
│   │   │   ├── java ####################################### Java 源代码
│   │   │   └── res ######################################## 资源目录(drawable、mipmap、values)
│   │   │   └── AndroidManifest.xml ######################## 应用模块配置文件
│   │   └── test ########################################### 单元测试目录
│   ├── build.gradle ####################################### 应用模块的 gradle 构建脚本
│   └── proguard-rules.pro ################################# 代码混淆规则
├── build ################################################## 编译生成目录
├── gradle ################################################# gradle wrapper 配置文件
├── build.gradle ########################################### gradle 全局构建脚本
├── gradle.properties ###################################### gradle 全局配置文件
├── gradlew ################################################ gradle 执行命令
├── gradlew.bat ############################################ gradle 执行命令
├── local.properties ####################################### 用于指定 Android SDK 开发路径
└── settings.gradle ######################################## 用于指定项目中所有引入的模块
```

Android 视图

```
.
├── app
│   ├── manifests ############################################## 应用模块配置文件
│   ├── java ################################################### Java 源代码(包含 androidTest、main 和 test 模块下的模块)
│   ├── res #################################################### 资源路劲
│   └── settings.gradle ######################################## 用于指定项目中所有引入的模块
└── Gradle Scripts ############################################# 配置文件目录
```
