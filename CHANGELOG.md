DriveChain Changelog
====================

1.4.0
-----

DebugDrawer Bridges

- `DebugDrawerBridgeModule` to bind `DeviceModule`, `BuildModule`, `NetworkModule`, and `SettingsModule` into the graph
- `DebugDrawerLocationBridgeModule` to bind a `LocationModule` into the graph that depends on a `LocationRequest`
- `DebugDrawerOkHttpBridgeModule` to bind `OkHttp3Module` and `NetworkQualityModule` into the graph
- `DebugDrawerLogsBridgeModule` to bind `LogsModule` into the graph

1.3.0
-----

Android Services Module compatible with AndroidInjectors

- added a module with the same functionality as AndroidServices, updated to work with the 
AndroidInjectors in Dagger 2.10+

1.2.0
-----

Dagger Update and new Joda Bridge library.

 - Update Dagger library to 2.14.1 – This allows user to use the latest Dagger
   version, since Dagger included a breaking change in its factories.
 - Add a Joda Time bridge to automatically initialize Joda time for Android.

1.1.1
-----

Critical bugfix related to Stetho bridge and OkHttp bridge interaction.

 - Fix for stetho runtime crash when used with okhttp

1.1.0
-----

This minor release focuses on improving the setup and ease of use for the 
framework.

 - Add `AppKernel` class to simplify imports and API for Application and Activity
   initialization calls.
 - Deprecate Application Lifecycle Subscriber Set kotlin extensions, to be 
   replaced with calls to `AppKernel`
 - Deprecate Lifecycle Registry Kotlin extensions, to be replaced with calls 
   to `AppKernel`
 - Add Lifecycle Voters to give libraries an automatic hook that can stop the 
   application initialization procedure. This is ueseful for bridges to 
   libraries with external application code such as LeakCanary 
 - Add a bridge for LeakCanary

1.0.1
-----
 - Fixed a Dependency loop error with the Logger Component.

1.0.0
-----
This release contained the initial buildout of the library framework including:

 - Application Lifecycle API
 - Activity Container Library
 - App Config API
 - Injectable Android Services for v26
 - Common Logger library
 - Library Bridges for Stetho, OkHttp and Fresco
