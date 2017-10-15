DriveChain Logger
=================

A Standardized, Injectable, and Stateless Logging Interface for Android.

Installation
------------

If you haven't already, add JitPack to your gradle repositories in your `build.gradle` file:

    repositories {
        maven {
            url "https://jitpack.io"
        }
    }

Add the dependency to your `build.gradle` file

    compile 'com.github.InkApplications.DriveChain:logger:1.+'

Requirements
------------

### Optional, but recommended.
 - **Dagger 2** – This library is designed to be used with [Dagger 2] Multi-mapping. You could use
   the interfaces without it, but it wouldn't be as convenient.
 - **Kotlin** – This library is written in Kotlin and focuses on Kotlin support. It uses optional
   arguments that will not be as useful in Java as in Kotlin.

Usage
-----

If you are using Dagger 2, Add the module to your application component:

```kotlin
@Singleton
@Component(modules = arrayOf(
    LoggerModule::class
))
interface ApplicationComponent {
  // ...
}
```

Then configure as many loggers as you'd like:

```kotlin
@Module class LogModule {
    @Provides @IntoSet fun logger(): Logger = ConsoleLogger()
}
```
