package drivechain.lifecycle.application

import android.app.Application

/** Convenience method for invoking `onCreate` for every subscriber in a collection. */
@Deprecated("Use AppKernel for initializing application.", ReplaceWith("appKernel.onCreate(this)"))
fun Iterable<ApplicationLifecycleSubscriber>.onCreate(application: Application) = forEach { it.onCreate(application) }

/** Convenience method for invoking `onTerminate` for every subscriber in a collection. */
@Deprecated("Use AppKernel for initializing application.", ReplaceWith("appKernel.onTerminate(this)"))
fun Iterable<ApplicationLifecycleSubscriber>.onTerminate(application: Application) = forEach { it.onTerminate(application) }

/** Convenience method for invoking `onLowMemory` for every subscriber in a collection. */
@Deprecated("Use AppKernel for initializing application.", ReplaceWith("appKernel.onLowMemory(this)"))
fun Iterable<ApplicationLifecycleSubscriber>.onLowMemory(application: Application) = forEach { it.onLowMemory(application) }

/** Convenience method for invoking `onTrimMemory` for every subscriber in a collection. */
@Deprecated("Use AppKernel for initializing application.", ReplaceWith("appKernel.onTrimMemory(this, level)"))
fun Iterable<ApplicationLifecycleSubscriber>.onTrimMemory(application: Application, level: Int) = forEach { it.onTrimMemory(application, level) }
