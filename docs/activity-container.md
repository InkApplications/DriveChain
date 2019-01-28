---
layout: page
title: Activity Container
---

DriveChain Activity Container
=============================

This component keeps track of your application's currently visible activity
in a container that can be used by background services.

This is particularly useful for background services that need to
conditionally run code like notifications based on what the user is
currently looking at.

Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    compile "com.github.InkApplications.DriveChain:activity-container:2.+"
```
    
Add the following module to your application component:
    
```kotlin
@Component(modules = arrayOf(
    ActivityContainerModule::class
))
interface ApplicationComponent {
  // ...
}
```

Usage
-----

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

[Lifecycle]: /lifecycle
