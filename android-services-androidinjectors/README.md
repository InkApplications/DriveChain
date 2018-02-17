---
layout: page
title: Android Services for AndroidInjectors
---

DriveChain Android Services for AndroidInjectors
===========================

This component provides Dagger2 modules for services that already exist
within Android, designed to be used with the new `AndroidInjectors` in Dagger 2.12+. 
Note that using this and the other Android Services module included in DriveChain is not supported 
and probably impossible. This module relies on you binding an application into the graph with a 
`Component.Builder` and relies on the `Activity` instance bound into the graph by using 
a `DispatchingAndroidInjector<Activity>`.

Installation
------------

Add the dependency to your `build.gradle` file

    compile "com.github.InkApplications.DriveChain:android-services:1.+"

Any of the Modules can be included in your application's Dagger component:

```kotlin
    @Component(modules = arrayOf(AndroidApplicationModule::class))
    interface MyApplicationComponent {}
```

Add your application to the graph by adding a builder with a `@BindsInstance` to your component:

```kotlin
    @Component(modules = arrayOf(AndroidApplicationModule::class))
    interface MyApplicationComponent {
        @Component.Builder interface Builder {
            @BindsInstance fun application(app: Application): AppComponent.Builder
            fun build(): AppComponent
        }
    }
```

Then build the component in your `Application` class:

```kotlin
    DaggerAppComponent
        .builder()
        .application(this)
        .build()
        .inject(this)
```

If the module requires the activity, it must be marked as an `@ActivityScope`:

```kotlin
    @Module abstract class ActivityBuilderModule {
        @ActivityScope @ContributesAndroidInjector(modules = [AndroidCompatActivityModule::class]) abstract fun myActivity() : MyActivity
    }
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