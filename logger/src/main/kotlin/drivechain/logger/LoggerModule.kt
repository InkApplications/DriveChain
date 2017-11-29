package drivechain.logger

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module class LoggerModule {
    @Provides @IntoSet fun defaultLogger(logger: Logger): Logger = EmptyLogger()
    @Provides fun loggers(loggers: Set<@JvmSuppressWildcards Logger>): Logger = LoggerCollection(loggers)
}
