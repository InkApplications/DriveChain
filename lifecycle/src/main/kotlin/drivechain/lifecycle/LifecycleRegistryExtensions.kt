package drivechain.lifecycle

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleRegistry

/** Add More than one observer at a time. What a novel concept. */
fun LifecycleRegistry.addObservers(observers: Collection<LifecycleObserver>) = observers.forEach { addObserver(it) }
