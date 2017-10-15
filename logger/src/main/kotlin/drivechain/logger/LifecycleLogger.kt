package drivechain.logger

import android.arch.lifecycle.*

/**
 * Logs each step of the Activity Lifecycle as they happen.
 */
class LifecycleLogger(private val logger: Logger): LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onEvent(owner: LifecycleOwner, event: Lifecycle.Event) {
        logger.info("Lifecycle: ${event.name} (${owner.javaClass.simpleName})")
    }
}
