## 应用场景

### 冷流

- 处理异步任务：传统的网络请求或数据库查询通常是异步操作，而 Flow 提供了一种统一的方式处理异步操作，特别是在需要多次请求或处理链式异步任务时。

    ```kotlin
    // 合并多个异步任务
    fun fetchUserData(): Flow<UserData> = flow {
        val userInfo = api.getUserInfo()  // 异步网络请求
        emit(userInfo)

        val userDetails = api.getUserDetails(userInfo.id) // 根据上次结果发起的请求
        emit(userDetails)
    }
    ```

- 处理实时数据流：当我们需要处理 实时更新 或 增量数据 的场景时，Flow 的流式处理能力比传统的同步/一次性返回更有优势。
- 操作符带来的流式处理能力：Flow 内置了丰富的操作符（例如 map、filter、combine、flatMapLatest），这些操作符允许你在数据流中对数据进行变换、过滤、组合等操作，而无需手动管理回调或异步逻辑。

    ```kotlin
    fun fetchProducts(): Flow<List<Product>> = api.getProducts()
        .map { products ->
            products.filter { it.isAvailable } // 过滤掉不可用的商品
        }
    ```

- 渐进式加载或多次返回：如果网络请求或数据库查询涉及到多步或批量加载 的场景，Flow 可以按需发射数据，而不是一次性返回所有结果。

    ```kotlin
    fun loadProductsInBatches(): Flow<List<Product>> = flow {
        var page = 0
        while (true) {
            val products = api.getProducts(page)
            if (products.isEmpty()) break // 没有更多商品，退出
            emit(products)
            page++
        }
    }
    ```

- 错误处理和重试机制：Flow 提供了处理异常的能力（如 catch、retry），使得在流中处理网络请求失败、数据库查询失败时更加方便。

    ```kotlin
    fun fetchProductWithRetry(): Flow<Product> = flow {
        emit(api.getProduct())
    }.retry(3) { e -> e is IOException } // 自动重试 3 次
    ```

- 并发与背压处理：当你需要处理大量数据或多个并发数据流时，Flow 提供了 背压控制 和 并发处理能力。这在高并发请求、并发数据库查询等场景下非常有用。
