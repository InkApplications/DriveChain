Fresco Bridge
=============

This component provides Dagger injection modules that automatically
connect to DriveChain's Application Callbacks for minimal setup

Installation
------------

Add the dependency to your `build.gradle` file

    compile "com.github.InkApplications.DriveChain:fresco-bridge:1.+'

Requirements
------------

This requires that you have an OkHTTP client set up as a dependency.
If you don't have one set up already, you can install the [bridge] for that
as well:

    debugCompile "com.github.InkApplications.DriveChain:okhttp-bridge:1.+'

[bridge]: ../okhttp-bridge/README.md

Usage
-----

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
