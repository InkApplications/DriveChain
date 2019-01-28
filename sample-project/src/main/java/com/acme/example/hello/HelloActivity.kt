package com.acme.example.hello

import android.os.Bundle
import com.acme.example.BaseActivity
import com.acme.example.R
import com.acme.example.dependencyinjection.ActivityComponent

class HelloActivity: BaseActivity() {
    override fun injectSelf(component: ActivityComponent) = component.inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.hello)
    }
}
