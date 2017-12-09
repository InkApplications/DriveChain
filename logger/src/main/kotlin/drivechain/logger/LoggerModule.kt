package drivechain.logger

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module class LoggerModule {
    @Provides @IntoSet fun defaultLogger(): Logger = EmptyLogger()
    @Provides fun loggers(loggers: Set<@JvmSuppressWildcards Logger>): Logger = LoggerCollection(loggers)
}
