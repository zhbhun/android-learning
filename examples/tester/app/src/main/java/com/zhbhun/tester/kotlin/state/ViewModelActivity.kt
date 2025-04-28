package com.zhbhun.tester.kotlin.state

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhbhun.tester.kotlin.databinding.ViewModelActivityBinding

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ViewModelActivityBinding

    private lateinit var counterViewModel: CounterViewModel
    private lateinit var counterWithInitialViewModel: CounterWithInitialViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ViewModelActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        binding.lifecycleOwner = this
        binding.counter = counterViewModel

        counterViewModel.count.observe(this) { count ->
            binding.counterValue.text = count.toString()
        }
        binding.counterDecrement.setOnClickListener {
            counterViewModel.decrement()
        }
        binding.counterIncrement.setOnClickListener {
            counterViewModel.increment()
        }

        counterWithInitialViewModel = ViewModelProvider(
            this,
            CounterWithInitialViewModelFactory(10)
        )[CounterWithInitialViewModel::class.java]
        counterWithInitialViewModel.count.observe(this) { count ->
            binding.counterWithInitialValue.text = count.toString()
        }
        binding.counterWithInitialDecrement.setOnClickListener {
            counterWithInitialViewModel.decrement()
        }
        binding.counterWithInitialIncrement.setOnClickListener {
            counterWithInitialViewModel.increment()
        }
    }
}


class CounterViewModel : ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun increment() {
        _count.value = (_count.value ?: 0) + 1
    }

    fun decrement() {
        _count.value = (_count.value ?: 0) - 1
    }
}


class CounterWithInitialViewModel(initialCount: Int) : ViewModel() {
    private val _count = MutableLiveData(initialCount)
    val count: LiveData<Int> = _count

    fun increment() {
        _count.value = (_count.value ?: 0) + 1
    }

    fun decrement() {
        _count.value = (_count.value ?: 0) - 1
    }
}


class CounterWithInitialViewModelFactory(private val i: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterWithInitialViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CounterWithInitialViewModel(i) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
