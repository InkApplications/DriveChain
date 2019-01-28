---
layout: page
title: Quick Setup for Drivechain
---

Quick Bootstrap Setup
=====================

This setup is best for new applications that can be more invested
in DriveChain's setup. It simplifies setup and forward-compatibility 
by using a base application class. If you prefer more granular control
over your application and dependencies, you can set the framework
up manually using the [Manual Start Guide]

[Manual Start Guide]:/manual-app-setup 

1) Install Core DriveChain Components
-------------------------------------

If you haven't already, add JitPack to your gradle repositories in your `build.gradle` file:

```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

Add DriveChain as a dependency to your `build.gradle` file

```gradle
dependencies {
    compile "com.github.InkApplications.DriveChain:bootstrap:2.+" // Replace with exact version
}
```

Add the modules to your Application component:

```kotlin
@Singleton @Component(modules = arrayOf(
    BootstrapModule::class
))
interface ApplicationComponent { /* ... */ }
```

2) Inject Application Base Class
--------------------------------

DriveChain is set up Automatically when inheriting from the 
`DriveChainApplication` base application class.

However, you will need to Inject your Application with your Dagger
component to provide the framework's `appKernel`.
You should inject your class in the `onAppCreate` function:

```kotlin
class MyApplication: DriveChainApplication() {
     val component: ApplicationComponent by lazy {
         DaggerApplicationComponent.builder()
             .androidApplicationModule(AndroidApplicationModule(this))
             .build()
     }
 
     @Inject override lateinit var appKernel: AppKernel
 
     override fun onAppCreate() = component.inject(this)
 }
```
