package com.acme.example.dependencyinjection

import com.acme.example.ExampleApplication
import com.acme.example.examples.ExamplesModule
import dagger.Component
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.bootstrap.BootstrapModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    BootstrapModule::class,
    ExamplesModule::class
])
interface ApplicationComponent {
    fun inject(target: ExampleApplication)

    fun createActivityComponent(activityServices: AndroidCompatActivityModule): ActivityComponent
}
