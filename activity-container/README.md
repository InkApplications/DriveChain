DriveChain Activity Container
=============================

This component keeps track of your application's currently visible activity
in a container that can be used by background services.

This is particularly useful for background services that need to
conditionally run code like notifications based on what the user is
currently looking at.

Installation
------------

If you haven't already, add JitPack to your gradle repositories in your `build.gradle` file:

    repositories {
        maven {
            url "https://jitpack.io"
        }
    }

Add the dependency to your `build.gradle` file

    compile 'com.github.InkApplications.DriveChain:activity-container:1.+'

Requirements
------------

### Optional, but recommended.
 - **Dagger 2** – This library is designed to be used with [Dagger 2] Multi-mapping. You could use
   the interfaces without it, but it wouldn't be as convenient.

Usage
-----

If you are using Dagger 2, Add the module to your application component to
automatically have the

```kotlin
@Singleton
@Component(modules = arrayOf(
    ActivityContainerModule::class
))
interface ApplicationComponent {
  // ...
}
```

Then you can run code only when a certain activity is displayed:

```kotlin
fun onMessageReceived(message: String) {
    activityContainer.onlyFor(TestActivity::class) { testActivity ->
        testActivity.showMessage(message)
    }
}
```

or access the current activity directly:

```kotlin
fun onMessageReceived(message: String) {
    if (activityContainer.activity == null) {
        // Application not visible right now
    }
}
```