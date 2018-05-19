package drivechain.logger

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * Logs each step of the Activity Lifecycle as they happen.
 */
class LifecycleLogger(private val logger: Logger): LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onEvent(owner: LifecycleOwner, event: Lifecycle.Event) {
        logger.info("Lifecycle: %s (%s)", event.name, owner.javaClass.simpleName)
    }
}
