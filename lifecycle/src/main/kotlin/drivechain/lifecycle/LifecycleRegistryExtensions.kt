package drivechain.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver

/** Add More than one observer at a time. What a novel concept. */
fun Lifecycle.addObservers(observers: Collection<LifecycleObserver>) = observers.forEach { addObserver(it) }
