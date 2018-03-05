---
layout: page
title: DebugDrawer Bridge
---

DebugDrawer Bridge
=============

This component uses DriveChain's application hooks to automatically initialize the [DebugDrawer].

Installation
------------

Add the dependency to your `build.gradle` file

```groovy
    debugCompile "com.github.InkApplications.DriveChain:debugdrawer-bridge:1.+"
    releaseCompile "com.github.InkApplications.DriveChain:debugdrawer-bridge-noop:1.+"
```

And any additional modules you wish to include

```groovy
    implementation "com.github.InkApplications.DriveChain:debugdrawer-location-bridge:$driveChainVersion"
    implementation "com.github.InkApplications.DriveChain:debugdrawer-logs-bridge:$driveChainVersion"
    implementation "com.github.InkApplications.DriveChain:debugdrawer-okhttp-bridge:$driveChainVersion"
```
 
Add the module to your application component:

```kotlin
    @Singleton
    @Component(modules = arrayOf(
        DebugDrawerBridgeModule::class
    ))
    interface ApplicationComponent {
      // ...
    }
```

Usage
-----

Simply inject this into an Activity for it to appear in debug builds. Provide the `DebugDrawer` from the module scoped with an activity.

```kotlin
    @Module(includes = [
        DebugDrawerBridgeModule::class,
        DebugDrawerOkHttpBridgeModule::class,
        DebugDrawerLogsBridgeModule::class
    ])
    class MainModule {
        @Provides @ActivityScope fun debugDrawer(activity: MainActivity, debugModules: Set<@JvmSuppressWildcards DebugModule>) : DebugDrawer {
            return DebugDrawer.Builder(activity).modules(*debugModules.debugModulesOrderedBySimpleClassName()).build()
        }
    }
```

If you need to add an additional `DebugModule`, simply bind it into the set like so: 

```kotlin
    @Provides @IntoSet fun debugModule() : DebugModule = MyDebugModule()
```

The location bridge binds a `DebugModule` into the graph that requires a `LocationRequest`, so be 
sure to provide one in any modules that include `DebugDrawerLocationBridgeModule`.

```kotlin
    @Module(includes = [
        DebugDrawerBridgeModule::class,
        DebugDrawerOkHttpBridgeModule::class,
        DebugDrawerLogsBridgeModule::class,
        DebugDrawerLocationBridgeModule::class
    ])
    class MapModule {
    
        @Provides @MapScope fun locationRequest() : LocationRequest {
            return LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                    .setInterval(5000)
        }
    
        @Provides @MapScope fun debugDrawer(activity: MapActivity, debugModules: Set<@JvmSuppressWildcards DebugModule>) : DebugDrawer {
            return DebugDrawer.Builder(activity).modules(*debugModules.debugModulesOrderedBySimpleClassName()).build()
        }
    }
```

Before the DebugDrawer can be bound with Dagger the activity must have called `setContentView`.
To get around this we can inject it as a Dagger `Lazy` type. 

```kotlin
    @Inject lateinit var debugDrawer: Lazy<DebugDrawer>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        debugDrawer.get()
    }
```

Now your [DebugDrawer] will exist on the right side of the `Activity`.

[DebugDrawer]: https://github.com/palaima/DebugDrawer
