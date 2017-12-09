---
layout: page
title: App Config
---

DriveChain AppConfig
====================

AppConfig is an object representation of your Application's AppConfig that
can be used to inject services that may need to rely on things like the debug
flag or version code.

Installation
------------

Add the dependency to your `build.gradle` file

    compile "com.github.InkApplications.DriveChain:app-config:1.+"

Usage
-----

### Create the AppConfig

Since Android's build configuration is Static, you will need to construct
the AppConfig manually:

```kotlin
@Module class AppConfigModule {
    @Provides @Singleton fun appConfig() = AppConfig(
        BuildConfig.DEBUG,
        BuildConfig.APPLICATION_ID,
        BuildConfig.VERSION_CODE,
        BuildConfig.VERSION_NAME,
        BuildConfig.BUILD_TYPE,
        BuildConfig.FLAVOR
    )
}
```

### Extra Metadata

You can add any extra build flags you have in the metadata property:

```kotlin
const val METADATA_API_KEY = "MAP_API_KEY"

@Module class AppConfigModule {
    @Provides @Singleton fun appConfig() = AppConfig(
        BuildConfig.DEBUG,
        BuildConfig.APPLICATION_ID,
        BuildConfig.VERSION_CODE,
        BuildConfig.VERSION_NAME,
        BuildConfig.BUILD_TYPE,
        BuildConfig.FLAVOR,
        mapOf(
            METADATA_API_KEY to BuildConfig.API_KEY
        )
    )
}

fun useAppConfig(config: AppConfig) {
    config.metaData.get(METADATA_API_KEY) // Retrieve the key from AppConfig
}
```
