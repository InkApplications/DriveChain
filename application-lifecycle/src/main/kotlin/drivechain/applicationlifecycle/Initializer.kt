package drivechain.applicationlifecycle

import android.app.Application


/**
 * Base class for Subscribers used to initialize services in `onCreate`
 *
 * This class just makes the other lifecycle events optional. If you find
 * yourself using them, your class might not be an initializer and can just
 * implement the `ApplicationLifecycleSubscriber` interface.
 *
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
abstract class Initializer: ApplicationLifecycleSubscriber {
    override fun onLowMemory(application: Application) = Unit
    override fun onTrimMemory(application: Application, level: Int) = Unit
    override fun onTerminate(application: Application) = Unit
}