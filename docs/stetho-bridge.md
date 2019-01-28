---
layout: page
title: Stetho Bridge
---

Stetho Bridge
=============

This component provides automatic setup and configuration of the [Stetho]
debugger.

Additionally, it provides a separate module that allows you to remove
Stetho as a dependency in release builds of your application.

Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    debugCompile "com.github.InkApplications.DriveChain:stetho-bridge:2.+"
    releaseCompile "com.github.InkApplications.DriveChain:stetho-bridge-noop:2.+"
```

Add the module to your application component:

```kotlin
@Component(modules = arrayOf(
    StethoBridgeModule::class
))
interface ApplicationComponent {
  // ...
}
```

Usage
-----

If you are using the [OkHttp Bridge] Stetho's Network Interceptor will
be connected automatically.

If you are using [OkHttp] manually, Stetho's interceptor will be injected with
the defined set of interceptors provided:

```kotlin
@Module class NetworkModule {
    @Provides @Singleton fun okHttp(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
        val builder = OkHttpClient.Builder()
        interceptors.forEach { builder.addNetworkInterceptor }

        return builder.build()
    }
}
```

[Stetho]: http://facebook.github.io/stetho/
[OkHttp]: http://square.github.io/okhttp/
[OkHttp Bridge] /okhttp-bridge
