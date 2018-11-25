package drivechain.activitycontainer

import android.arch.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module class ActivityContainerModule {
    @Provides @Singleton fun activityContainer() = ActivityContainer()
    @Provides @IntoSet fun lifecycleObserver(container: ActivityContainer): LifecycleObserver = container
}
