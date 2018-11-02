package drivechain.bridge.threeten

import dagger.Module
import dagger.Provides
import drivechain.lifecycle.application.ApplicationLifecycleSubscriber

@Module class ThreeTenBridgeModule {
    @Provides fun initializer(): ApplicationLifecycleSubscriber = ThreeTenInitializer
}
