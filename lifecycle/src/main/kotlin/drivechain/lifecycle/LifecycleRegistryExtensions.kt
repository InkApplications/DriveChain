package drivechain.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

/** Add More than one observer at a time. What a novel concept. */
@Deprecated("Use AppKernel for binding lifeycyle observers.", ReplaceWith("appKernel.bindLifecycle(lifecycle)"))
fun Lifecycle.addObservers(observers: Collection<LifecycleObserver>) = observers.forEach { addObserver(it) }
