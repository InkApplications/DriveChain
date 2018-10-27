package com.acme.example.hello

import com.acme.example.BaseActivity
import com.acme.example.dependencyinjection.ActivityComponent

class HelloActivity: BaseActivity() {
    override fun injectSelf(component: ActivityComponent) = component.inject(this)
}
