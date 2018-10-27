package com.acme.example.dependencyinjection

import com.acme.example.ExampleApplication
import dagger.Component
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.bootstrap.BootstrapModule

@Component(modules = [
    BootstrapModule::class,
    AppConfigModule::class
])
interface ApplicationComponent {
    fun inject(target: ExampleApplication)

    fun createActivityComponent(activityServices: AndroidCompatActivityModule): ActivityComponent
}
