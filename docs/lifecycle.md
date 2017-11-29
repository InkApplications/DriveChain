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
    compile 'com.github.InkApplications.DriveChain:lifecycle:1.+'
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

#### Inject Application Subscribers

Obtain your set of application subscribers. With Dagger 2, you can inject the collection
as you would any other service:

```kotlin
class MyApplication: Application() {
    @Inject lateinit var lifecycleSubscribers: Set<@JvmSuppressWildcards ApplicationLifecycleSubscriber>
}
```

#### Invoke Application Callbacks

Next, make sure each of the lifecycle steps are passed along to the callbacks.

```kotlin
class MyApplication: Application() {
    @Inject lateinit var lifecycleSubscribers: Set<@JvmSuppressWildcards ApplicationLifecycleSubscriber>

    override fun onCreate() {
        super.onCreate()
        lifecycleSubscribers.onCreate(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        lifecycleSubscribers.onTerminate(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        lifecycleSubscribers.onLowMemory(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        lifecycleSubscribers.onTrimMemory(this, level)
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

### Activity Lifecycle

Android Architecture components have already brought a great way to hook into
the Activity lifecycle. You can use them in the same manner as the Application
components

```kotlin
class MyActivity: AppCompatActivity {
    @Inject lateinit var lifecycleComponents: Set<@JvmSuppressWildcards LifecycleObserver>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registry.addObservers(lifecycleComponents)
    }
}
```
