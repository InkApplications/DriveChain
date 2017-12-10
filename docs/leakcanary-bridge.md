---
layout: page
title: LeakCanary Bridge
---

Fresco Bridge
=============

This component uses DriveChain's application hooks to automatically
initialize and configure [LeakCanry] for memory leak analysis.

Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    compileDebug "com.github.InkApplications.DriveChain:leakcanary-bridge:1.+"
    compileRelease "com.github.InkApplications.DriveChain:leakcanary-bridge:1.+"
```
 
Add the module to your application component:

```kotlin
@Singleton
@Component(modules = arrayOf(
    LeakCanaryBridgeModule::class
))
interface ApplicationComponent {
  // ...
}
```

Usage
-----

Everything is set up for you. Start using [LeakCanary] exactly how you
normally would.

[LeakCanary]: https://github.com/square/leakcanary
