Stetho Bridge
=============

This component provides Dagger injection modules that automatically
connect to DriveChain's Application Callbacks for minimal setup

Installation
------------

Add the dependency to your `build.gradle` file

    debugCompile "com.github.InkApplications.DriveChain:stetho-bridge:1.+'
    releaseCompile "com.github.InkApplications.DriveChain:stetho-bridge-noop:1.+'


Usage
-----

Add the module to your application component:

```kotlin
@Singleton
@Component(modules = arrayOf(
    StethoBridgeModule::class
))
interface ApplicationComponent {
  // ...
}
```

If you are using OkHTTP, you can automatically Inject Stetho's Injector
when injecting the Interceptor Set provided by Dagger:

```kotlin
@Module class NetworkModule {
    @Provides @Singleton okHttp(interceptors: Set<@JvmSuppressWildcards Interceptor>) {
        val builder = OkHttpClient.Builder()
        interceptors.forEach { builder.addNetworkInterceptor }

        return builder.build()
    }
}
```