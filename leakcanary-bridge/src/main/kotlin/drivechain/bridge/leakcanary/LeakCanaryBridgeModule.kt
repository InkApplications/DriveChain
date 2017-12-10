package drivechain.bridge.leakcanary

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.lifecycle.application.ApplicationLifecycleSubscriber
import drivechain.lifecycle.application.LifecycleVoter

/**
 * Creates dependencies that hook into the application events and properly
 * configure LeakCanary to run in your application.
 */
@Module class LeakCanaryBridgeModule {
    @Provides @IntoSet fun voter(): LifecycleVoter = LeakCanaryVoter()
    @Provides @IntoSet fun initializer(): ApplicationLifecycleSubscriber = LeakCanaryInitializer()
}
