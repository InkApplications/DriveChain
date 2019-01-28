package com.acme.example.examples

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import dagger.Reusable
import drivechain.logger.Logger
import javax.inject.Inject

/**
 * Automatically listens to events from every activity.
 *
 * This class is automatically bound by Drivechain when available in
 * Dagger. This is done in the module just by binding it to the
 * `LifecycleObserver` set.
 */
@Reusable class ExampleActivityListener @Inject constructor(
    private val logger: Logger
): LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(target: LifecycleOwner) {
        logger.info("👋 Hello newly created Activity!")
    }
}
