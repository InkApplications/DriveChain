package drivechain.lifecycle

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import drivechain.lifecycle.application.*

/**
 * Calls Application lifecycle events with a cleaner API.
 *
 * This simplifies the injections and some of the business logic around
 * invoking lifecycle events to make installation easier and less fragile.
 *
 * Lifecycle callbacks are invoked after every Lifecycle voter is invoked
 * to check for any interrupted events.
 */
class AppKernel(
    private val lifecycleVoters: Set<@JvmSuppressWildcards LifecycleVoter>,
    private val lifecycleSubscribers: Set<@JvmSuppressWildcards ApplicationLifecycleSubscriber>,
    private val androidLifecycleObservers: Set<@JvmSuppressWildcards LifecycleObserver>
) {
    /**
     * Invokes application callbacks. Add to your Application's `onCreate` method.
     */
    fun onCreate(application: Application) = vote {
        it.onCreate(application)
    } action {
        lifecycleSubscribers.forEach { it.onCreate(application) }
    }

    /**
     * Invokes application callbacks. Add to your Application's `onTerminate` method.
     */
    fun onTerminate(application: Application) = vote {
        it.onTerminate(application)
    } action {
        lifecycleSubscribers.forEach { it.onTerminate(application) }
    }

    /**
     * Invokes application callbacks. Add to your Application's `onLowMemory` method.
     */
    fun onLowMemory(application: Application) = vote {
        it.onLowMemory(application)
    } action {
        lifecycleSubscribers.forEach { it.onLowMemory(application) }
    }

    /**
     * Invokes application callbacks. Add to your Application's `onTrimMemory` method.
     */
    fun onTrimMemory(application: Application, level: Int) = vote {
        it.onTrimMemory(application, level)
    } action {
        lifecycleSubscribers.forEach { it.onTrimMemory(application, level) }
    }

    /**
     * Bind Android lifecycle observers to a lifecycle for an activity.
     */
    fun bindLifecycle(lifecycle: Lifecycle) = androidLifecycleObservers.forEach { lifecycle.addObserver(it) }

    private inline fun vote(voteAction: (LifecycleVoter) -> Boolean) = lifecycleVoters.filterNot(voteAction)

    private inline infix fun List<LifecycleVoter>.action(action: () -> Unit) {
        if (isEmpty()) action()
    }
}
