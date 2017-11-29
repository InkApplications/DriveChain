package drivechain.logger

import android.arch.lifecycle.LifecycleObserver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.appconfig.AppConfig

@Module(includes = arrayOf(LoggerModule::class)) class AutoLoggers {
    @Provides @IntoSet fun lifecycleLogger(logger: Logger): LifecycleObserver = LifecycleLogger(logger)

    @Provides @IntoSet fun consoleLogger(config: AppConfig): Logger  {
        return if (config.debug) {
            ConsoleLogger()
        } else {
            ConsoleLogger(
                debugEnabled = false,
                traceEnabled = false
            )
        }
    }
}
