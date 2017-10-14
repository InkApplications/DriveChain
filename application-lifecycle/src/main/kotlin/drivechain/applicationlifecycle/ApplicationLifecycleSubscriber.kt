package drivechain.applicationlifecycle

import android.app.Application

/**
 * Callbacks for Android Application lifecycle events.
 *
 * Similar to Android's `ApplicationLifecycleCallbacks` interface, this provides
 * methods for each of the Application's lifecycle events so that they may
 * be observed.
 * Since there is no callback structure built into Android, these callbacks
 * have to be invoked manually on the Application Class.
 *
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
interface ApplicationLifecycleSubscriber {
    fun onCreate(application: Application)
    fun onLowMemory(application: Application)
    fun onTrimMemory(application: Application, level: Int)
    fun onTerminate(application: Application)
}