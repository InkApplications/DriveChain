package com.acme.example.examples

import android.arch.lifecycle.LifecycleObserver
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

/**
 * Bind dependencies into sets.
 *
 * Dependencies that require the `@IntoSet` annotation must be
 * declared in a module (for technical reasons)
 * This is so that Dagger knows what set we are grouping the class
 * into. ex.
 *
 *     @Binds @IntoSet abstract fun example(listener: MyListener): LifecycleObserver
 *              ^                                         ^             ^
 *              |                  Dependency being bound-'             |
 *              |                                                       |
 *              |                                                       |
 *              `- We're binding a dependency into a set of this type --'
 *
 */
@Module abstract class ExamplesModule {
    @Binds @IntoSet abstract fun activityListener(listener: ExampleActivityListener): LifecycleObserver
}
