package drivechain.bridge.joda

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.lifecycle.application.ApplicationLifecycleSubscriber


@Module
class JodaBridgeModule {
    @Provides @IntoSet fun joda(): ApplicationLifecycleSubscriber = JodaInitializer()
}