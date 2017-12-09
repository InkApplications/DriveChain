package drivechain.lifecycle.application

import android.app.Application

/**
 * A Lifecycle voter that always votes yes.
 *
 * This is good for testing, placeholders, and delegation as it will not effect
 * the application lifecycle events.
 */
class YesVoter: LifecycleVoter {
    override fun onCreate(application: Application) = true
    override fun onLowMemory(application: Application) = true
    override fun onTrimMemory(application: Application, level: Int) = true
    override fun onTerminate(application: Application) = true
}
