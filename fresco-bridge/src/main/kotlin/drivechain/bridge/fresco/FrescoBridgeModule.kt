package drivechain.bridge.fresco

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.lifecycle.application.ApplicationLifecycleSubscriber
import okhttp3.OkHttpClient

@Module class FrescoBridgeModule {
    @Provides @IntoSet fun fresco(okHttpClient: OkHttpClient): ApplicationLifecycleSubscriber = FrescoInitializer(okHttpClient)
}