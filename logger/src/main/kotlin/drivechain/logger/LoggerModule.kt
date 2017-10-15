package drivechain.logger

import android.arch.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module class LoggerModule {
    @Provides @IntoSet fun lifecycleLogger(logger: Logger): LifecycleObserver = LifecycleLogger(logger)
    @Provides fun loggers(loggers: Set<@JvmSuppressWildcards Logger>): Logger = LoggerCollection(loggers)
}