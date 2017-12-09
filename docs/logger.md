---
layout: page
title: DriveChain Logger
---

DriveChain Logger
=================

DriveChain includes a common Logger Component. This was important so that
components in Drivechain could share common logging logic without having to
implement their own interface every time.

Automatic Logging
-----------------

DriveChain's Logger is configured to automatically start working upon 
installation as you can expect with any DriveChain component. By default,
it will log all Lifecycle events to the console. They will look like this:

    Lifecycle: ON_PAUSE (WidgetActivity)

Lifecycle events are logged at the `INFO` level of logging.
When your application is in debug mode, you can expect all levels to be 
logged to the console. When debug is turned of (ie. for release builds)
The default console logger will only log `ERROR`, `WARN` and `INFO` messages.

Installation
------------

Add the dependency to your `build.gradle` file

```gradle
    compile "com.github.InkApplications.DriveChain:logger:1.+"
```

Add the Logger Module to your Application Component.

```kotlin
@Singleton @Component(modules = arrayOf(
    // ...
    AutoLoggers::class
))
interface ApplicationComponent { /* ... */ }
```

Writing to the Logger
---------------------

To write to the logger yourself, just inject the drivechain `Logger` interface:

```kotlin
class Foo @Inject constructor(
    private val logger: Logger
) {
    fun bar() {
        logger.debug("Hello World!")
    }
}
```

DriveChain will automatically send the log message to the console and every 
other logger that is registered.

Customizing the Logger
----------------------

Want to add your own custom Logger? Easy.

All you have to do is add your logger into your applicaiton's Dagger module:

```kotlin
@Module class MyApplicationModule {
    @Provides @IntoSet fun customLogger(): Logger = CustomLogger()
}
```

Now your logger will receive all the events that every other logger does.
And you can add *as many loggers as you want!* They will all receive the
same logging events.

Don't like DriveChain's automatic loggers? Don't use them!
You can just include the bare `LoggerModule` class instead of `AutoLoggers`
This will only contain the composite logger that ties all of your custom
loggers together.

```kotlin
@Singleton @Component(modules = arrayOf(
    // ...
    LoggerModule::class
))
interface ApplicationComponent { /* ... */ }
```

Why Not Timber, or Slf4j?
-------------------------

Static Logging libraries like Timber and Slf4j require static configuration on 
your application in order to get started. The goal of DriveChain was to get rid
of that. The loggger in Drivechain is configured with sensible defaults that
can be used with very little configuration on your end. 
