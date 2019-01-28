---
layout: page
title: Manual Setup for Drivechain
---

Manual Setup
============

This setup is best for existing applications, or when applications want
more control over their Application class and minimal dependencies.
If you prefer a simpler installation, see our [Quick Start Guide].

[Quick Start Guide]:/quick-app-setup 

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
    compile "com.github.InkApplications.DriveChain:lifecycle:2.+" // Replace with exact version
    compile "com.github.InkApplications.DriveChain:logger:2.+" // Replace with exact version
}
```

Add the modules to your Application component:

```kotlin
@Singleton @Component(modules = arrayOf(
    LifecycleModule::class,
    AutoLoggers::class
))
interface ApplicationComponent { /* ... */ }
```

2) Add Application Hooks
------------------------

Android does not provide a built-in way of hookin into the Application's 
lifecycle, but DriveChain does. This means you'll have to invoke 
Drivechain's kernel at each of the lifecycle events.

DriveChain's components rely on these events to function, this step is required
for each method.

```kotlin
class MyApplication: Application() {
    @Inject lateinit var appKernel: AppKernel

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent().create().inject(this) // Inject the application with Dagger before calling Lifecycles
        appKernel.onCreate(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        appKernel.onTerminate(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        appKernel.onLowMemory(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        appKernel.onTrimMemory(this, level)
    }
}
```
