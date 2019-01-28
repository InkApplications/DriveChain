package com.acme.example.dependencyinjection

import com.acme.example.BaseActivity
import com.acme.example.hello.HelloActivity
import dagger.Subcomponent
import drivechain.androidservices.ActivityScope
import drivechain.androidservices.AndroidCompatActivityModule

@ActivityScope
@Subcomponent(modules = [
    AndroidCompatActivityModule::class
])
interface ActivityComponent {
    fun injectBase(target: BaseActivity)

    fun inject(target: HelloActivity)
}
