package drivechain.lifecycle.application

import android.app.Application

/**
 * API for deciding whether Application lifecycle callbacks should be invoked.
 *
 * Occasionally, libraries need to run an application without initializing all
 * of your framework code. (ex. LeakCanary, ProcessPhoenix)
 * Typically these libraries just have a function to check if the application
 * was launched as one of their processes. This interface allows libraries to
 * automatically veto the initialization process for *all* libraries.
 *
 * These voters are invoked *before* the Application Lifecycle callback events.
 *
 * Remember: Each of these events can be vetoed individually, however if the
 * `onCreate` event is vetoed, application libraries will **not** have been
 * initialized and might not function properly in subsequent events! It is
 * generally good practice to veto all events if you veto the `onCreate` event.
 */
interface LifecycleVoter {
    /**
     * Decide whether the `onCreate` lifecycle event should be invoked.
     *
     * @return `true` to proceed with the OnCreate event, `false` to veto.
     */
    fun onCreate(application: Application): Boolean

    /**
     * Decide whether the `onLowMemory` lifecycle event should be invoked.
     *
     * @return `true` to proceed with the OnCreate event, `false` to veto.
     */
    fun onLowMemory(application: Application): Boolean

    /**
     * Decide whether the `onTrimMemory` lifecycle event should be invoked.
     *
     * @return `true` to proceed with the OnCreate event, `false` to veto.
     */
    fun onTrimMemory(application: Application, level: Int): Boolean

    /**
     * Decide whether the `onTerminate` lifecycle event should be invoked.
     *
     * @return `true` to proceed with the OnCreate event, `false` to veto.
     */
    fun onTerminate(application: Application): Boolean
}
