package drivechain.bridge.debugdrawer

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import io.palaima.debugdrawer.logs.LogsModule

@Module class DebugDrawerLogsBridgeModule {
    @Provides @IntoSet fun logsModule() : DebugDrawerSection = LogsModule()
}
