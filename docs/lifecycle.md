---
layout: page
title: Lifecycle
---

DriveChain Lifecycle
====================

This component provides a missing interface for Android's Application
lifecycle events and tools to more easily hook into Android's activity
lifecycle.

Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    compile "com.github.InkApplications.DriveChain:lifecycle:2.+"
```

Add the Lifecycle module to your Application Component:

```kotlin
@Component(modules = arrayOf(
    LifecycleModule::class
))
interface ApplicationComponent {
  // ...
}
```

### Modify your Application Class

Since android does not have built in callbacks for the Application lifecycle, you will need to
modify your application to invoke the interface directly.

#### Inject AppKernel

DriveChain's AppKernel manages dispatching your lifecycle events easily.

```kotlin
class MyApplication: Application() {
    @Inject lateinit var appKernel: AppKernel
}
```

#### Invoke Application Callbacks

Next, make sure each of the lifecycle steps are passed along to the callbacks.

```kotlin
class MyApplication: Application() {
    @Inject lateinit var appKernel: AppKernel

    override fun onCreate() {
        super.onCreate()
        appKernel.onCreate(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        appKernel.onTerminate(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        appKernel.onLowMemory(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        appKernel.onTrimMemory(this, level)
    }
}
```

#### Create Application Lifecycle Subscribers

Now, you can create a de-coupled lifecycle subscriber just by adding it to the set, and without
cluttering your Application class. With Dagger 2, this is as easy as annotating your
class with the `@IntoSet` qualifier.

```kotlin
class WidgetInitializer: Initializer() {
    override fun onCreate(application: Application) {
        TODO()
    }
}
```

And add it to your set using Dagger's Multi-binding:

```kotlin
@Module class WidgetModule {
    @Provides @IntoSet fun widget(): ApplicationLifecycleSubscriber = WidgetInitializer()
}
```

#### Lifecycle Voters

In rare cases, some libraries need to be able to interrupt the initialization
of your application libraries. This typically occurs if the library needs to
launch its own packaged activity without your application class logic. 
Lifecycle voters are invoked before the lifecycle subscribers, and have the
ability to stop the normal lifecycle subscribers from being invoked.

You create a Lifecycle Voter similar to a Lifecycle Subscriber, however
each method will return a Boolean. Returning `true` will proceed as normal,
but returning `false` will prevent *all* lifecycle subscribers from being 
invoked, stopping your application initialization.

```kotlin
class WidgetVoter: LifecycleVoter {
    override fun onCreate(application: Application) = if (someCondition) true else false
    override fun onLowMemory(application: Application) = true
    override fun onTrimMemory(application: Application, level: Int) = true
    override fun onTerminate(application: Application) = true
}
```

And add it to your set using Dagger's Multi-binding:

```kotlin
@Module class WidgetModule {
    @Provides @IntoSet fun widget(): LifecycleVoter = WidgetVoter()
}
```

### Activity Lifecycle

Android Architecture components have already brought a great way to hook into
the Activity lifecycle. You can use them in the same manner as the Application
components

```kotlin
class MyActivity: AppCompatActivity {
    @Inject lateinit var appKernel: AppKernel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appKernel.bindLifecycle(lifecycle)
    }
}
```
