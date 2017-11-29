---
layout: page
title: OkHttp Bridge
---

OkHttp Bridge
=============

A Default implementation of [OkHttp]. The Bridge module provided by this
component constructs a basic version of OkHttp that is set up to bind to
HTTP interceptors.

OkHttp is set up with a 50MB Cache, stored in the application's cache directory.


Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    compile "com.github.InkApplications.DriveChain:okhttp-bridge:1.+'
```

Add the module to your application component:

```kotlin
@Component(modules = arrayOf(
    OkHttpBridgeModule::class
))
interface ApplicationComponent {
  // ...
}
```

Usage
-----

The OkHttp class is configured and ready to be injected and used normally.

### Binding Interceptors (optional)

OkHttp, as provided by this package, will bind to the set of Interceptors
provided by Dagger. This means to add an interceptor to OkHttp, you just need
to configure a provider:

```kotlin
@Module class MyNetworkModule {
    @Provides @IntoSet fun customInterceptor(): Interceptor = MyCustomInterceptor()
}
```

If you want to bind a **Network** Interceptor specifically, you can use
the `@NetworkOnly` qualifier on your provider.

```kotlin
@Module class MyNetworkModule {
    @Provides @NetworkOnly @IntoSet fun networkInterceptor(): Interceptor = MyNetworkInterceptor()
}
```

[OkHttp]: http://square.github.io/okhttp/
