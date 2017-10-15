package drivechain.activitycontainer

import android.arch.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module class ActivityContainerModule {
    @Provides @IntoSet fun activityContainer(): LifecycleObserver = ActivityContainer()
}