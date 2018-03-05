package drivechain.bridge.debugdrawer

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import io.palaima.debugdrawer.base.DebugModule
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.commons.SettingsModule

@Module class DebugDrawerBridgeModule {
    @Provides @IntoSet fun deviceModule() : DebugModule = DeviceModule()
    @Provides @IntoSet fun buildModule() : DebugModule = BuildModule()
    @Provides @IntoSet fun networkModule() : DebugModule = NetworkModule()
    @Provides @IntoSet fun settingsModule() : DebugModule = SettingsModule()
}

fun Set<DebugModule>.debugModulesOrderedBySimpleClassName() : Array<io.palaima.debugdrawer.base.DebugModule> {
    return this.toList().sortedWith(compareBy({ it.javaClass.simpleName })).toTypedArray()
}