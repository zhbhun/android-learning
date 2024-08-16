package com.zhbhun.tester.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.zhbhun.tester.kotlin.databinding.EmptyActivityBinding

class LifecycleObserverActivity : AppCompatActivity() {

    private lateinit var binding: EmptyActivityBinding
     private val myObserver = MyObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = EmptyActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(myObserver)
    }
}

class MyObserver : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        println("create");
        // Your onCreate logic here
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        println("start");
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        println("resume");
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        println("pause");
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        println("stop");
        // Your onStop logic here
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        println("destroy");
    }
}
