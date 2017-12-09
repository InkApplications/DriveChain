---
layout: page
title: Setup DriveChain on an existing App
---

Set up with an existing application
===================================

This guide will walk you through all the changes necessary to use DriveChain
as a framework on an existing application.
Before you get started, ensure that your application follows the requirements
described in the [Getting Started] documentation.

[Getting Started]:/start 

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
    compile "com.github.InkApplications.DriveChain:lifecycle:1.+" // Replace with exact version
    compile "com.github.InkApplications.DriveChain:app-config:1.+" // Replace with exact version
    compile "com.github.InkApplications.DriveChain:logger:1.+" // Replace with exact version
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

3) Add Activity & Fragment Hooks
--------------------------------

DriveChain uses Android's Architecture components to hook into individual
screen lifecycles.

If you are using a base activity/fragment, it's recommended that this be 
added in there:

```kotlin
class BaseActivity: AppCompatActivity() {
    @Inject lateinit var appKernel: AppKernel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this) // Dagger Injections must run before adding observers.
        appKernel.bindLifecycle(lifecycle)
    }
}
```

Or for a Fragment:

```kotlin
class BaseFragment: AppCompatActivity() {
    @Inject lateinit var appKernel: AppKernel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        component.inject(this)  // Dagger Injections must run before adding observers.
        appKernel.bindLifecycle(lifecycle)
    }
}
```

4) Create an Application Config
-------------------------------

Android's build configurations are static and therefore not accessible
to external libraries. DriveChain fixes that by creating a configuration
singleton that libraries can access.

To set this up, just create a Dagger module that supplies an `AppConfig`
object for injections, and enter your build config settings:

```kotlin
@Module class AppConfigModule {
    @Provides @Singleton fun appConfig() = AppConfig(
        BuildConfig.DEBUG,
        BuildConfig.APPLICATION_ID,
        BuildConfig.VERSION_CODE,
        BuildConfig.VERSION_NAME,
        BuildConfig.BUILD_TYPE,
        BuildConfig.FLAVOR
    )
}
```

Then include it in your Application's Dagger Component:

```kotlin
@Component(modules = arrayOf(
    // ...
    AppConfigModule::class,
))
interface ApplicationComponent {
    // ...
}
```
