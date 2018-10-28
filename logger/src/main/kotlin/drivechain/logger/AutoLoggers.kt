package drivechain.logger

import androidx.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.appconfig.AppConfig

@Module(includes = [LoggerModule::class]) class AutoLoggers {
    @Provides @IntoSet fun lifecycleLogger(logger: Logger): LifecycleObserver = LifecycleLogger(logger)

    @Provides @IntoSet fun consoleLogger(config: AppConfig): Logger  {
        return if (config.debug) {
            ConsoleLogger(loggerOffset = 3)
        } else {
            ConsoleLogger(
                loggerOffset = 3,
                debugEnabled = false,
                traceEnabled = false
            )
        }
    }
}
