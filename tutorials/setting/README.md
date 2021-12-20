# 配置文件

## 资源配置

- drawable：图片
- mipmap：应用图标
- layout：布局文件
- values：字符串

用法如下所示：

```
//java
R.xxx.xxx
// res
@xxx/xxx
```

## gradle

- `./build.gradle`：最顶层的编译配置文件，用于配置子项目或模块的公共配置

    ```gradle
    buildscript {
        // 开源项目仓库配置
        repositories {
            google()
            mavenCentral()
        }
        // 依赖配置
        dependencies {
            // 配置 gradle 的 android 构建插件
            classpath "com.android.tools.build:gradle:7.0.3"
        }
    }

    task clean(type: Delete) {
        delete rootProject.buildDir
    }
    ```

- `./app/build.gradle`：app 模块的编译配置文件

    ```gradle
    // 使用插件
    plugins {
        id 'com.android.application' // 应用程序模块
        // id 'com.android.library' // 应用程序模块
    }

    android {
        compileSdk 30 // 编译工具的版本

        defaultConfig {
            applicationId "com.zhbhun.tester.java" // 项目包名
            minSdk 21 // 最低兼容的 Android 系统版本
            targetSdk 30 // 要编译的目标 Android 系统版本
            versionCode 1 // 应用版本号
            versionName "1.0" // 应用版本名称

            testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        }

        buildTypes {
            // release 用于指定正式版安装文件的配置
            release {
                // 是否开启混淆
                minifyEnabled false
                // 混淆规则 `proguard-android-optimize.txt` 是 Android SDK 下的通用混淆规则，`proguard-rules.pro` 是应用根目录下的自定义混淆规则
                proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro' 
            }
            // debug 用于指定测试版安装文件的配置，在 Android Studio 下运行的都是测试版
        }
        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }
    }

    // 依赖配置：本地依赖、库依赖和远程依赖
    dependencies {
        // 本地依赖
        // implementation fileTree(dir: 'libs', include: ['*.jar'])

        // 库依赖
        // implementation project(':helper')

        // 远程依赖
        implementation 'androidx.appcompat:appcompat:1.3.1'
        implementation 'com.google.android.material:material:1.4.0'
        implementation 'androidx.constraintlayout:constraintlayout:2.1.1'

        // 测试依赖
        testImplementation 'junit:junit:4.+'
        androidTestImplementation 'androidx.test.ext:junit:1.1.3'
        androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    }

```
