package com.acme.example

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.acme.example.dependencyinjection.ActivityComponent
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.lifecycle.AppKernel
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {
    val exampleApplication get() = application as ExampleApplication

    val component by lazy {
        exampleApplication.component
            .createActivityComponent(AndroidCompatActivityModule(this))
    }

    @Inject lateinit var appKernel: AppKernel

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.injectBase(this)
        injectSelf(component)
        appKernel.bindLifecycle(lifecycle)
    }

    abstract fun injectSelf(component: ActivityComponent)
}
