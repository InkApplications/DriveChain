package drivechain.activitycontainer

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import java.lang.ref.WeakReference
import kotlin.reflect.KClass

/**
 * Holds onto a reference of the foreground activity in the app.
 *
 * This is used for services that run in the background but need to know if there
 * is a foreground activity running (like notifications)
 *
 * This holds a weak reference to not leak the activity memory.
 */
class ActivityContainer: LifecycleObserver {
    private var recentActivity: WeakReference<Activity>? = null
    val activity get() = recentActivity?.get()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onActivityPaused(owner: LifecycleOwner) {
        when (owner) {
            is Activity -> recentActivity = null
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onActivityResumed(owner: LifecycleOwner) {
        when (owner) {
            is Activity -> recentActivity = WeakReference(owner)
        }
    }

    /**
     * Run a block of code *only* when a specified activity is in the foreground.
     */
    inline fun <T : Activity> onlyFor(activityClass: KClass<T>, body: (T) -> Unit) {
        if (activity != null && activity!!::class == activityClass) body(activity as T)
    }
}