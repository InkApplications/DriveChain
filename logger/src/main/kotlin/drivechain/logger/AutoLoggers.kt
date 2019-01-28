package drivechain.logger

import android.arch.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.appconfig.AppInfo

@Module(includes = [LoggerModule::class]) class AutoLoggers {
    @Provides @IntoSet fun lifecycleLogger(logger: Logger): LifecycleObserver = LifecycleLogger(logger)

    @Provides @IntoSet fun consoleLogger(config: AppInfo): Logger  {
        return if (config.debug) {
            ConsoleLogger(loggerOffset = 2)
        } else {
            ConsoleLogger(
                loggerOffset = 2,
                logLevel = LogLevel.INFO
            )
        }
    }
}
