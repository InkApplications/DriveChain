---
layout: page
title: Joda-Time Bridge
---

Joda-Time Bridge
=============

This component uses DriveChain's application hooks to automatically initialize [Joda-Time].

Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    compile "com.github.InkApplications.DriveChain:joda-bridge:2.+"
```
 
Add the module to your application component:

```kotlin
@Singleton
@Component(modules = arrayOf(
    JodaBridgeModule::class
))
interface ApplicationComponent {
  // ...
}
```

Usage
-----

Everything is set up for you. Start using [Joda-Time] exactly how you normally would.

[Joda-Time]: https://github.com/dlew/joda-time-android
