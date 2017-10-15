DriveChain Android Services
===========================

This component provides Dagger2 modules for services that already exist
within Android.

Installation
------------

If you haven't already, add JitPack to your gradle repositories in your `build.gradle` file:

    repositories {
        maven {
            url "https://jitpack.io"
        }
    }

Add the dependency to your `build.gradle` file

    compile 'com.github.InkApplications.DriveChain:android-services:1.+'

Requirements
------------

This application requires Dagger2 and the Android Support Library.
Services provided by the modules in this component are targeted at support
classes and services wherever possible.

Usage
-----

Any of the Modules can be included in your application's Dagger component:

```kotlin
    @Singleton
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