package drivechain.bootstrap

import android.app.Application
import drivechain.lifecycle.AppKernel

/**
 * Application with AppKernel hooks.
 *
 * This adds AppKernel hooks to each of the application callbacks.
 * The Application's lifecycle methods are then sealed off, as any
 * further logic can be done in a Lifecycle Observer.
 *
 * Using this class is not required, and is only designed to reduce
 * boilerplate in the application.
 *
 * To use this, you will need to provide the AppKernel, typically
 * through dependency injection.
 */
abstract class DriveChainApplication: Application() {
    protected abstract val appKernel: AppKernel

    /**
     * Called after onCreate, but before DriveChain's onCreate is called.
     *
     * This is a good time to create the AppKernel required by this class
     * as well as any other code that may need to run before DriveChain's
     * lifecycle observers are invoked.
     */
    open fun onAppCreate() = Unit

    final override fun onCreate() {
        super.onCreate()
        onAppCreate()
        appKernel.onCreate(this)
    }

    final override fun onTerminate() {
        super.onTerminate()
        appKernel.onTerminate(this)
    }

    final override fun onLowMemory() {
        super.onLowMemory()
        appKernel.onLowMemory(this)
    }

    final override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        appKernel.onTrimMemory(this, level)
    }
}
