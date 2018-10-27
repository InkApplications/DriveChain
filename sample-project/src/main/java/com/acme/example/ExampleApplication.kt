package com.acme.example

import com.acme.example.dependencyinjection.ApplicationComponent
import com.acme.example.dependencyinjection.DaggerApplicationComponent
import drivechain.androidservices.AndroidApplicationModule
import drivechain.bootstrap.DriveChainApplication
import drivechain.lifecycle.AppKernel
import javax.inject.Inject

class ExampleApplication: DriveChainApplication() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .androidApplicationModule(AndroidApplicationModule(this))
            .build()
    }

    @Inject override lateinit var appKernel: AppKernel

    override fun onAppCreate() = component.inject(this)
}
