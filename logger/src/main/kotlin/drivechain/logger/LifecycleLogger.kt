package drivechain.logger

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent

/**
 * Logs each step of the Activity Lifecycle as they happen.
 */
class LifecycleLogger(private val logger: Logger): LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onEvent(owner: LifecycleOwner, event: Lifecycle.Event) {
        logger.log(LogLevel.INFO, "Lifecycle Event: %s", event.name, tag = owner.javaClass.simpleName)
    }
}
