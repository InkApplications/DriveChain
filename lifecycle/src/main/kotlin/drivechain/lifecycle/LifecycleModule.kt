package drivechain.lifecycle

import androidx.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.lifecycle.application.*

/**
 * Services useful for the lifecycle components.
 */
@Module class LifecycleModule {
    /** Empty Application Subscriber so that the user doesn't have to have any for it to compile. */
    @Provides @IntoSet fun firstApplicationLifecycle(): ApplicationLifecycleSubscriber = EmptyApplicationSubscriber()
    /** Empty Lifecycle Observer so that the user doesn't have to have any for it to compile. */
    @Provides @IntoSet fun firstActivityLifecycle(): LifecycleObserver = object: LifecycleObserver {}

    /** Empty Lifecycle voter so that the user doesn't have to have any for it to compile. */
    @Provides @IntoSet fun defaultVoter(): LifecycleVoter = YesVoter()

    /** AppKernel for ease of initialization in Application and activity classes. */
    @Provides fun kernel(
        voters: Set<@JvmSuppressWildcards LifecycleVoter>,
        subscribers: Set<@JvmSuppressWildcards ApplicationLifecycleSubscriber>,
        androidLifecycleObservers: Set<@JvmSuppressWildcards LifecycleObserver>
    ) = AppKernel(voters, subscribers, androidLifecycleObservers)
}
