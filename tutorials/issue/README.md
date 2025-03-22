## 不支持泛化的高阶函数

## 不支持声明参数可选的函数类型

```kotlin
val greet = fun(name: String = "Guest") {
    println("Hello, $name!")
}
// An anonymous function is not allowed to specify default values for its parameters
```
