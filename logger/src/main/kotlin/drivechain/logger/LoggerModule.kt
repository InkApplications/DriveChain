package drivechain.logger

import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds

typealias Loggers = Set<@JvmSuppressWildcards Logger>

@Module(includes = [LoggerDefinitionModule::class]) class LoggerModule {
    @Provides fun loggers(loggers: Loggers): Logger = CompositeLogger(loggers)
}

@Module internal abstract class LoggerDefinitionModule {
    @Multibinds abstract fun loggerSet(): Loggers
}
