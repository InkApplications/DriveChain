package drivechain.applicationlifecycle

import android.app.Application

/**
 * Base class for Subscribers used to handle memory Events.
 *
 * This class just makes the other lifecycle events optional. If you find
 * yourself using them, your class might not be an memory manager and can just
 * implement the `ApplicationLifecycleSubscriber` interface.
 *
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
abstract class MemoryManager : ApplicationLifecycleSubscriber {
    override fun onCreate(application: Application) = Unit
    override fun onTerminate(application: Application) = Unit
}