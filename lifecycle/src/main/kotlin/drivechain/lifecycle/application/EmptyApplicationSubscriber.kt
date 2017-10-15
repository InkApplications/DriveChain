package drivechain.lifecycle.application

import android.app.Application

/**
 * A no-op Application Lifecycle Subscriber that can be used for testing or for Delegation.
 *
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
class EmptyApplicationSubscriber: ApplicationLifecycleSubscriber {
    override fun onCreate(application: Application) = Unit
    override fun onLowMemory(application: Application) = Unit
    override fun onTrimMemory(application: Application, level: Int) = Unit
    override fun onTerminate(application: Application) = Unit
}