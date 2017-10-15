package drivechain.lifecycle

import android.arch.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.lifecycle.application.ApplicationLifecycleSubscriber
import drivechain.lifecycle.application.EmptyApplicationSubscriber

/**
 * Services useful for the lifecycle components.
 */
@Module class LifecycleModule {
    /** Empty Application Subscriber so that the user doesn't have to have any for it to compile. */
    @Provides @IntoSet fun firstApplicationLifecycle(): ApplicationLifecycleSubscriber = EmptyApplicationSubscriber()
    /** Empty Lifecycle Observer so that the user doesn't have to have any for it to compile. */
    @Provides @IntoSet fun firstActivityLifecycle(): LifecycleObserver = object: LifecycleObserver {}
}