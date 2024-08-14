- https://kotlinlang.org
- [Learn Kotlin by Example](https://play.kotlinlang.org/byExample/overview)
- [Kotlin STDLib](https://kotlinlang.org/api/latest/jvm/stdlib/)
- [面向编程人员的 Kotlin 训练营](https://developer.android.com/courses/kotlin-bootcamp/overview?hl=zh-cn)

## Variables

```kotlin
var a: String = "initial"
a = "Changed"
val b: Int = 1
val c = 3

var e: Int
println(e) // Variable 'e' must be initialized
```

## Type

### Null

```kotlin
var neverNull: String = "This can't be null"
neverNull = null // compile error

var nullable: String? = "You can keep a null here"
nullable = null

var inferredNonNull = "The compiler assumes non-null"
inferredNonNull = null // compile error
```

### Number

### Boolean

### String

- Template

    ```kotlin
    val greeting = "Kotliner"
    println("Hello $greeting")
    println("Hello ${greeting.uppercase()}")
    ```

## Expression

- 算术表达式
- 比较表达式

### Equality

```kotlin
val authors = setOf("Shakespeare", "Hemingway", "Twain")
val writers = setOf("Twain", "Shakespeare", "Hemingway")

println(authors == writers)   // true，结构比较 => if (a == null) b == null else a.equals(b)
println(authors === writers)  // false，引用比较
```

### Conditional

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b 
```

ps：没有三元表达式

### When

```kotlin
fun main() {
    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))
}

fun whenAssign(obj: Any): Any {
    val result = when (obj) {
        1 -> "one"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }
    return result
}

class MyClass
```

### Infix

- [`to`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/)

    ```
    val pair1 = 1 to "x"
    val pair2: Pair<Int, String> = 2 to "y"
    ```

### Destructuring

```
val (x, y, z) = arrayOf(5, 10, 15)

val map = mapOf("Alice" to 21, "Bob" to 25)
for ((name, age) in map) {                                      // 2
    println("$name is $age years old")          
}

val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))

data class User(val username: String, val email: String)
val user = User("Mary", "mary@somewhere.com")
// Data class automatically defines the component1() and component2() methods that will be called during destructuring.
val (username, email) = user
```

## Statement

- 条件
- 循环


### when

```kotlin
fun main() {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}

fun cases(obj: Any) {                                
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }   
}

class MyClass
```

### for

```kotlin
val cakes = listOf("carrot", "cheese", "chocolate")

for (cake in cakes) {
    println("Yummy, it's a $cake cake!")
}
```

### while / do-while

```
fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

fun main(args: Array<String>) {
    var cakesEaten = 0
    var cakesBaked = 0
    
    while (cakesEaten < 5) {
        eatACake()
        cakesEaten ++
    }
    
    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

}
```

### Iterator

```kotlin
class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

fun main() {

    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

    for (animal in zoo) {
        println("Watch out, it's a ${animal.name}")
    }

}
```

### Range

```
for(i in 0..3) {
    print(i)
}

for(i in 0 until 3) {
    print(i)
}

for(i in 2..8 step 2) {
    print(i)
}

for (i in 3 downTo 0) {
    print(i)
}

for (c in 'a'..'d') {
    print(c)
}

for (c in 'z' downTo 's' step 2) {
    print(c)
}

val x = 2
if (x in 1..5) {
    print("x is in range from 1 to 5")
}
if (x !in 6..10) {
    print("x is not in range from 6 to 10")
}
```

## Collections

### List

```kotlin
val readonlyUsers: List<Int> = listOf('a', 'b', 'c') // read-only
val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
val sudoers: List<Int> = systemUsers // read-only

// acccess
val list = listOf(0, 10, 20)
println(list.getOrElse(1) { 42 }) // 10
println(list.getOrElse(10) { 42 }) // 42

// filter
val numbers = listOf(1, -2, 3, -4, 5, -6)
val positives = numbers.filter { x -> x > 0 }
val negatives = numbers.filter { it < 0 }

// map
val numbers = listOf(1, -2, 3, -4, 5, -6)
val doubled = numbers.map { x -> x * 2 }
val tripled = numbers.map { it * 3 }

// check
val numbers = listOf(1, -2, 3, -4, 5, -6)
val anyNegative = numbers.any { it < 0 } // true
val allEven = numbers.all { it % 2 == 0 } // false 
val allOdd = numbers.none { it % 2 == 0 } // false

// find
val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
val first = words.find { it.startsWith("some") }
val last = words.findLast { it.startsWith("some") }
val numbers = listOf(1, -2, 3, -4, 5, -6)
val firstNumber = numbers.first()
val lastNumber = number.last()
val firstEven = numbers.first { it % 2 == 0 }
val lastOdd = numbers.last { it % 2 != 0 }
var firstNumberOrNull = empty.firstOrNull()
val lastNumberOrNull = number.lastOrNull()
val firstEvenOrNull = numbers.firstOrNull { it % 2 == 0 }
val lastOddOrNull = numbers.lastOrNull { it % 2 != 0 }

// count
val numbers = listOf(1, -2, 3, -4, 5, -6)
val totalCount = numbers.count() // 6
val evenCount = numbers.count { it % 2 == 0 } // 3

// associateBy, groupBy
data class Person(val name: String, val city: String, val phone: String)
val people = listOf(
    Person("John", "Boston", "+1-888-123456"),
    Person("Sarah", "Munich", "+49-777-789123"),
    Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
    Person("Vasilisa", "Saint-Petersburg", "+7-999-123456")
)
val phoneBook = people.associateBy { it.phone } // Map<String, Person>
val cityBook = people.associateBy(Person::phone, Person::city) // Map<String, String>
val peopleCities = people.groupBy(Person::city, Person::name) // Map<String, List<Person>>
val lastPersonCity = people.associateBy(Person::city, Person::name) // Map<String, List<Person>>

// partition
val numbers = listOf(1, -2, 3, -4, 5, -6)
val evenOdd = numbers.partition { it % 2 == 0 } // Pair<List<Int>, List<Int>>
val (positives, negatives) = numbers.partition { it > 0 } // List<Int>

// flat
val fruitsBag = listOf("apple","orange","banana","grapes")
val clothesBag = listOf("shirts","pants","jeans")
val cart = listOf(fruitsBag, clothesBag)
val flatMapBag = cart.flatMap { it } // List<String> 

// min, max
val numbers = listOf(1, 2, 3)
val empty = emptyList<Int>()
val only = listOf(3)
println("Numbers: $numbers, min = ${numbers.minOrNull()} max = ${numbers.maxOrNull()}") // 1 3
println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}") // null null
println("Only: $only, min = ${only.minOrNull()}, max = ${only.maxOrNull()}") // 3 3

// sort
val shuffled = listOf(5, 4, 2, 1, 3, -10)
val natural = shuffled.sorted() // Sorts it in the natural order.
val inverted = shuffled.sortedBy { -it } // Sorts it in the inverted natural order
val descending = shuffled.sortedDescending() // Sorts it in the inverted natural order
val descendingBy = shuffled.sortedByDescending { abs(it) } // Sorts it in the inverted natural order of items' absolute values

// zip
val A = listOf("a", "b", "c")
val B = listOf(1, 2, 3, 4)
val resultPairs = A zip B // List<Pair<String, Int>>
val resultReduce = A.zip(B) { a, b -> "$a$b" } // List<String>
```

### Set

```kotlin
val readonlyUsers: Set<Int> = setOf('a', 'b', 'c')
val systemUsers: MutableSet<Int> = mutableSetOf(1, 2, 3)
val sudoers: Set<Int> = systemUsers // read-only
```

### Map

```kotlin
val accounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
val readonlyAccounts: Map<Int, Int> = accounts // mapOf(1 to 100, 2 to 100, 3 to 100)

// access
val map = mapOf("key" to 42)
val value1 = map["key"] // 42
val value2 = map["key2"] // null
val value3: Int = map.getValue("key") // 42
val mapWithDefault = map.withDefault { k -> k.length }
val value4 = mapWithDefault.getValue("key2") // 4
map.getOrElse("anotherKey") { 0 } // 0
map.getValue("anotherKey") // NoSuchElementException
```

## Function

### Unit

```kotlin
fun printMessage(message: String) {
    println(message)
}

fun printMessageWithUnit(message: String): Unit {
    println(message)
}
```

### Named Argument

```kotlin
fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
}
printMessageWithPrefix("Hello", "Log")
printMessageWithPrefix(prefix = "Log", message = "Hello")
```

### Default Parameter

```kotlin
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}
printMessageWithPrefix("Hello")
```

### Express Function

```kotlin
fun makeSound(n: String) = println("I'm The King of Rock 'N' Roll: $n")
```

### Infix Functions

具有单个参数的成员函数和扩展可以转换为中缀函数。

```kotlin
infix fun Int.times(str: String) = str.repeat(this)
println(2 times "Bye ")

val pair = "Ferrari" to "Katrina"
println(pair)

infix fun String.onto(other: String) = Pair(this, other)
val myPair = "McLaren" onto "Lucas"
println(myPair)

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }
}
val sophia = Person("Sophia")
val claudia = Person("Claudia")
sophia likes claudia
```

### Operator Functions

```kotlin
operator fun Int.times(str: String) = str.repeat(this)
println(2 * "Bye ")

operator fun String.get(range: IntRange) = substring(range)
val str = "Always forgive your enemies; nothing annoys them so much."
println(str[0..14])
```

### vararg

```kotlin
fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}
printAll("Hello", "Hallo", "Salut", "Hola", "你好")

fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}
printAllWithPrefix(
    "Hello", "Hallo", "Salut", "Hola", "你好",
    prefix = "Greeting: "
)

fun log(vararg entries: String) {
    printAll(*entries)
}
log("Hello", "Hallo", "Salut", "Hola", "你好")
```

### Higher-Order

高阶函数是将另一个函数作为参数和/或返回一个函数的函数。

- Functions as Parameters

    ```kotlin
    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)
    }

    fun sum(x: Int, y: Int) = x + y

    fun main() {
        val sumResult = calculate(4, 5, ::sum) // :: 是 Kotlin 中按名称引用函数的表示法。
        val mulResult = calculate(4, 5) { a, b -> a * b }
        println("sumResult $sumResult, mulResult $mulResult")
    }
    ```

- Returning Functions

    ```kotlin
    fun operation(a: Int, b: Int): () -> Int {
        return { add(a, b) }
    }

    fun add(x: Int, y: Int) = x + y

    fun main() {
        val func = operation(3, 5)
        println(func())  // 输出 8
    }
    ```

### Anonymous

```kotlin
val anonymousFunc = fun(x: Int, y: Int): Int {
    return x + y
}
```

ps：匿名函数使用 fun 关键字，且可以显式指定返回类型。

### Lambda

```kotlin
val upperCase1: (String) -> String = { str: String -> str.uppercase() }

val upperCase2: (String) -> String = { str -> str.uppercase() } // lambda 参数的类型是根据它分配给的变量的类型推断出来的。

val upperCase3 = { str: String -> str.uppercase() } // 根据 lambda 参数的类型和返回值推断变量的类型。

// val upperCase4 = { str -> str.uppercase() }

val upperCase5: (String) -> String = { it.uppercase() } // 只有一个参数时，可以使用隐式 it 变量

val upperCase6: (String) -> String = String::uppercase // lambda 由单个函数调用组成时，可以使用函数指针

println(upperCase1("hello"))
println(upperCase2("hello"))
println(upperCase3("hello"))
println(upperCase5("hello"))
println(upperCase6("hello"))
```

ps: 区分 Anonymous 和 Lambda

- 语法不通

    - 匿名函数使用 fun 关键字，且可以显式指定返回类型。
    - Lambda 表达式使用 {} 定义，参数在 -> 之前，返回值是表达式的结果。

- 返回值类型

    - 在匿名函数中，你可以显式指定返回值类型，这在某些需要精确控制返回类型的场景中非常有用。
	- Lambda 表达式的返回值类型通常由 Kotlin 编译器自动推断。

- return 语义不同:
	
    - 在匿名函数中，return 语句的行为与常规函数相同，它会从匿名函数中返回值。
	- 在 lambda 表达式中，return 语句会从包含 lambda 的外部函数返回值，这在处理嵌套代码块时尤为重要。

### Scope

- let: executes the given block of code and returns the result of its last expression.

    ```kotlin
    val empty = "test".let {
        customPrint(it)
        it.isEmpty()
    }
    println(" is empty: $empty")
    ```

- run: executes a code block and returns its result. The difference is that inside run the object is accessed by this.

    ```kotlin
    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {
            println("\tis empty? " + isEmpty())
            println("\tlength = $length")
            length
        }
    }
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with Kotlin")
    ```

- with: with is a non-extension function that can access members of its argument concisely.

    ```kotlin
    with(configuration) {
        println("$host:$port")
    }
    ```

- apply: executes a block of code on an object and returns the object itself.

    ```kotlin
    val jake = Person()
    val stringDescription = jake.apply {
        name = "Jake"
        age = 30
        about = "Android developer"
    }.toString()
    ```

- also: it executes a given block and returns the object called. Inside the block, the object is referenced by it, so it's easier to pass it as an argument.

    ```kotlin
    val jake = Person("Jake", 30, "Android developer")
        .also {
            writeCreationLog(it)
        }
    ```
## Interface

```kotlin
interface SoundBehavior {
    fun makeSound()
}

class ScreamBehavior(val n:String): SoundBehavior {
    override fun makeSound() = println("${n.uppercase()} !!!")
}

class RockAndRollBehavior(val n:String): SoundBehavior {
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
}
```

## 类

```kotlin
class Customer
class Contact(val id: Int, var email: String)

val customer = Customer()
val contact = Contact(1, "mary@gmail.com")
println(contact.id)
contact.email = "jane@gmail.com"
```

### Properties

```kotlin
class ClassName {
    // 属性
    var propertyName: PropertyType = initialValue
}
```

### Method

```kotlin
class ClassName {
    // 方法
    fun methodName(parameters): ReturnType {
        // 方法体
    }
}
```

### Constructor

- primary

    ```kotlin
    class Contact(val id: Int, var email: String) // 主构造函数是直接在类名后定义的，通常用于初始化类的属性。
    ```

- secondary

    ```kotlin
    class Rectangle(val width: Double, val height: Double) {
        fun area(): Double {
            return width * height
        }

        // 次构造函数
        constructor(side: Double) : this(side, side) // 次构造函数只接受一个参数 side，并调用主构造函数来创建一个正方形。
    }
    ```

- init：在主构造函数被调用时立刻执行，可以用于属性的初始化、参数的验证和执行初始化逻辑等。

    ```kotlin
    class Person(val name: String, var age: Int) {
        // init 块
        init {
            println("Initializing a new Person instance.")
            if (age < 0) {
                throw IllegalArgumentException("Age cannot be negative")
            }
        }

        fun displayInfo() {
            println("Name: $name, Age: $age")
        }
    }
    ```

    ps：可以有多个 init 块，按照它们在类中出现的顺序依次执行。

### Inheritance

- Inheritance

    ```kotlin
    open class Dog {
        open fun sayHello() {
            println("wow wow!")
        }
    }

    class Yorkshire: Dog() {
        override fun sayHello() {
            println("wif wif!")
        }
    }

    val dog: Dog = Yorkshire()
    dog.sayHello()
    ```
- Inheritance with Parameterized Constructor

    ```kotlin
    open class Tiger(val origin: String) {
        fun sayHello() {
            println("A tiger from $origin says: grrhhh!")
        }
    }

    class SiberianTiger : Tiger("Siberia")                  // 1

    fun main() {
        val tiger: Tiger = SiberianTiger()
        tiger.sayHello()
    }
    ```

### Data Class

自动为此类提供用于复制、获取字符串表示形式和在集合中使用实例的方法。

```kotlin
data class User(val name: String, val id: Int) {
    override fun equals(other: Any?) =
        other is User && other.id == this.id
}
fun main() {
    val user = User("Alex", 1)
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // 如果两个实例的 id相等，则我们的自定义 equals 认为两个实例相等。
    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    // hashCode() function，具有完全匹配属性的数据类实例具有相同的 hashCode。
    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // copy() function，自动生成的复制功能使创建新实例变得容易。
    println(user.copy())
    println(user === user.copy())
    println(user.copy("Max")) // Copy 接受的参数顺序与类构造函数的顺序相同。
    println(user.copy(id = 3)) // 使用带有命名参数的 copy 来更改值，而不考虑属性顺序。

    // 通过自动生成的 componentN 函数，您可以按照声明的顺序获取属性的值。
    println("name = ${user.component1()}")
    println("id = ${user.component2()}")
}
```

ps：有点像 ts 的 interface，又有点像 dart 的 record

### Enum Class

- Enum

    ```kotlint
    enum class State {
        IDLE, RUNNING, FINISHED
    }

    fun main() {
        val state = State.RUNNING
        val message = when (state) {
            State.IDLE -> "It's idle"
            State.RUNNING -> "It's running"
            State.FINISHED -> "It's finished"
        }
        println(message)
    }

- Properties and Methods

    ```kotlin
    enum class Color(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF),
        YELLOW(0xFFFF00);

        fun containsRed() = (this.rgb and 0xFF0000 != 0)
    }

    fun main() {
        val red = Color.RED
        println(red) // 默认的 toString 返回常量的名称，此处为“RED”。
        println(red.containsRed()) // 在枚举常量上调用方法。
        println(Color.BLUE.containsRed()) // 通过枚举类名调用方法。
        println(Color.YELLOW.containsRed())
    }
    ```

### Sealed Classes

Sealed Classes 可以限制继承的使用。一旦声明了一个 sealed 类，它就只能从声明 sealed 类的同一包内部进行子类化。它不能在声明密封类别的包之外进行子类化。

```kotlin
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"
    }
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}
```

### Object Keyword

- object Expression

    ```kotlin
    fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

        val dayRates = object {
            var standard: Int = 30 * standardDays
            var festivity: Int = 50 * festivityDays
            var special: Int = 100 * specialDays
        }

        val total = dayRates.standard + dayRates.festivity + dayRates.special

        print("Total price: $$total")

    }

    fun main() {
        rentPrice(10, 2, 1)
    }
    ```

- object Declaration

    ```kotlin
    object DoAuth {                                                 //1 
        fun takeParams(username: String, password: String) {        //2 
            println("input Auth parameters = $username:$password")
        }
    }

    fun main(){
        DoAuth.takeParams("foo", "qwerty")                          //3
    }
    ```
    
- Companion Objects：类似类的静态属性

    ```kotlin
    class BigBen {
        companion object Bonger {
            fun getBongs(nTimes: Int) {
                for (i in 1 .. nTimes) {
                    print("BONG ")
                }
            }
        }
    }

    fun main() {
        BigBen.getBongs(12)
    }
    ```

ps：类似 JS 对象字面量

### Extension

Kotlin 允许您使用扩展机制向任何类添加新成员。

```kotlin
data class Item(val name: String, val price: Float)

data class Order(val items: Collection<Item>)

// 为 Order 类型添加扩展函数。
fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

// 为 Order 类型添加扩展属性。
val Order.commaDelimitedItemNames: String
    get() = items.map { it.name }.joinToString()

// 甚至可以在 null 引用上执行扩展。
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"

fun main() {

    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))
    
    println("Max priced item name: ${order.maxPricedItemName()}")
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")

    val nullString: String? = null
    println(nullString.nullSafeToString())  // 输出 "NULL"
}
```

### Delegation

- Delegation Pattern

    ```kotlin
    interface SoundBehavior {
        fun makeSound()
    }

    class ScreamBehavior(val n:String): SoundBehavior {
        override fun makeSound() = println("${n.uppercase()} !!!")
    }

    class RockAndRollBehavior(val n:String): SoundBehavior {
        override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
    }

    // Tom Araya is the "singer" of Slayer
    class TomAraya(n:String): SoundBehavior by ScreamBehavior(n)

    // You should know ;)
    class ElvisPresley(n:String): SoundBehavior by RockAndRollBehavior(n)

    fun main() {
        val tomAraya = TomAraya("Thrash Metal")
        tomAraya.makeSound()
        val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
        elvisPresley.makeSound()
    }
    ```

- Delegated Properties

    ```kotlin
    import kotlin.reflect.KProperty

    class Example {
        var p: String by Delegate()

        override fun toString() = "Example Class"
    }

    class Delegate() {
        operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${prop.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
            println("$value has been assigned to ${prop.name} in $thisRef")
        }
    }

    fun main() {
        val e = Example()
        println(e.p)
        e.p = "NEW"
    }
    ```

- lazy

    ```kotlin
    class LazySample {
        init {
        println("created!")
        }
        
        val lazyStr: String by lazy {
            println("computed!")
            "my lazy"
        }
    }

    fun main() {
        val sample = LazySample()
        println("lazyStr = ${sample.lazyStr}")
        println(" = ${sample.lazyStr}")
    }
    ```

- blockingLazy
- observable
- map

    ```kotlin
    class User(val map: Map<String, Any?>) {
        val name: String by map
        val age: Int     by map
    }
    fun main() {
        val user = User(mapOf("name" to "John Doe", "age"  to 25))
        println("name = ${user.name}, age = ${user.age}")
    }
    ```

## Generic

- Class

    ```kotlin
    class MutableStack<E>(vararg items: E) {

        private val elements = items.toMutableList()

        fun push(element: E) = elements.add(element)

        fun peek(): E = elements.last()

        fun pop(): E = elements.removeAt(elements.size - 1)

        fun isEmpty() = elements.isEmpty()

        fun size() = elements.size

        override fun toString() = "MutableStack(${elements.joinToString()})"
    }
    ```

- Function

    ```kotlin
    fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)
    ```
