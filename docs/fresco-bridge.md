---
layout: page
title: Fresco Bridge
---

Fresco Bridge
=============

This component uses DriveChain's application hooks to automatically
initialize and configure [Fresco] using [OkHttp] for network calls.

Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    compile "com.github.InkApplications.DriveChain:fresco-bridge:1.+'
```
 
Add the module to your application component:

```kotlin
@Singleton
@Component(modules = arrayOf(
    FrescoBridgeModule::class
))
interface ApplicationComponent {
  // ...
}
```

Requirements
------------

This requires that you have an OkHTTP client set up as a dependency.
If you don't have one set up already, you can install the [OkHttp Bridge] 
for that as well:

[bridge]: /okhttp-bridge

Usage
-----

Everything is set up for you. Start using [Fresco] exactly how you
normally would.

[Fresco]: http://frescolib.org/
[OkHttp]: http://square.github.io/okhttp/
