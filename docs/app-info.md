---
layout: page
title: App Info
---

DriveChain App Info
===================

AppInfo is an object representation of your Application's AppConfig that
can be used to inject services that may need to rely on things like the debug
flag or version code.

Installation
------------

Add the dependency to your `build.gradle` file

    compile "com.github.InkApplications.DriveChain:app-info:2.+"

Add the Module to your Application Component:

```kotlin
    @Component(modules = arrayOf(AppInfoModule::class))
    interface MyApplicationComponent {}
```

Usage
-----

Once installed, this module provides access to intrinsics about the 
application build. It can be injected into any class:

```kotlin
class Example @Inject constructor(
    private val appInfo: AppInfo
) {
    fun example() {
        if (appInfo.debug) {
            // Yay! non-static access to build config!
        }
    }
}
```

