# Gradle

## 依赖管理

### 仓库

#### 仓库类型

- Maven
- Ivy
- 静态文件或文件夹

#### 仓库管理

##### 预定义仓库

- mavenCentral：maven 官方的远程仓库
- mavenLocal：已经使用了的所有依赖的本地缓存，通常放在用户主目录下的 .m2 目录文件夹下
- google：google 官方的远程仓库
- jcenter：JCenter 是 Maven Central 的超集

    ps：已废弃

```gradle
repositories {
    jcenter()
    google()
    mavenCentral()
    mavenLocal()
}
```

##### 私有仓库

```gradle
repository {
    maven {
        url 'http://...'
    }
    ivy {
        url 'http://...'
    }
}
```

##### 仓库镜像

- 阿里云：https://developer.aliyun.com/mvn/guide

    https://help.aliyun.com/document_detail/102512.html


```gradle
repositories {
    maven {
      url 'https://maven.aliyun.com/repository/public/'
    }
    maven {
      url 'https://maven.aliyun.com/repository/spring/'
    }
    mavenLocal()
    mavenCentral()
}
```

##### 本地仓库

```gradle
repositories {
    maven {
      url './repo'
    }
}
```

### 依赖

#### 本地依赖

- 本地文件/文件夹

    ```gradle
    dependencies {
        compile files('libs/domoarigato.jar')
        compile fileTree('libs')
        compile fileTree(dir: 'libs', include: ['*.jar'])
    }
    ```

- 原生依赖

    ```gradle
    android {
        sourceSets.main {
            jniLibs.srcDir 'src/main/libs'
        }
    }
    ```

- 依赖项目：依赖项目构建会生成一个 `.aar` 文件

    依赖项目要使用 Android 的依赖库插件

    ```gradle
    apply plugin: 'com.android.library'
    ```

    - 同项目模块


        ```gradle
        // setting.gradle
        include ':app', ':library'

        // app/build.gradle
        dependencies {
            compile project(':library')
        }
        ```

    - 多应用复用模块（.aar）

        ```gralde
        repositories {
            flatDir {
                dirs 'aars'
            }
        }
        dependencies {
            compile(name: 'libraryname', ext: 'aar')
        }
        ```

#### 依赖配置

- compile
- apk
- provided
- testCompile
- androidTestCompile

#### 区分环境

- compile

    - releaseCompile
    - debugCompile

- ...


#### 版本语义化

`major.minor.patch`

