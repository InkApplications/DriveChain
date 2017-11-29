---
layout: page
title: Android Services
---

DriveChain Android Services
===========================

This component provides Dagger2 modules for services that already exist
within Android.

Installation
------------

Add the dependency to your `build.gradle` file

    compile 'com.github.InkApplications.DriveChain:android-services:1.+'

Any of the Modules can be included in your application's Dagger component:

```kotlin
    @Component(modules = arrayOf(AndroidApplicationModule::class))
    interface MyApplicationComponent {}
```

This will require the module to be passed in upon creation of the component:

```kotlin
    DaggerMyApplicationComponent.builder()
            .androidApplicationModule(AndroidApplicationModule(application))
            .build()
```

If the module requires the activity, it must be marked as an `@ActivityScope`
component:

```kotlin
    @ActivityScope
    @Component(modules = arrayOf(AndroidCompatActivityModule::class))
    interface MyActivityComponent {}
```

Available Modules
-----------------

There are three primary modules provided by this library:

### AndroidApplicationModule

This module provides dagger injections for the services that lurk within
the Android Application class.


### AndroidSystemServiceModule

This module provides dagger injections for the services that are hidden
behind the `Context.getSystemService(String)` factory. All the services
will be type-safe when they are injected with this module. No more casting!

### AndroidCompatActivityModule

This module provides injections for the services inside the Activity class.
These require an instance of the Support Library's AppCompatActivity and are
limited to the ActivityScope.

Usage
-----

Once the modules are installed, you can start requiring standard Android
services in your classes like any other injection:

```kotlin
class Foo @Inject constructor(
    private val resources: Resources,
    private val notificationManager: NotificationManager
)
```
