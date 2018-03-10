package drivechain.bridge.debugdrawer

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import io.palaima.debugdrawer.base.DebugModule
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.commons.SettingsModule

typealias DebugDrawerSection = DebugModule

/**
 * [Module] to bind a bare bones set of [DebugModule] into the graph.
 */
@Module class DebugDrawerBridgeModule {
    @Provides @IntoSet fun deviceModule() : DebugDrawerSection = DeviceModule()
    @Provides @IntoSet fun buildModule() : DebugDrawerSection = BuildModule()
    @Provides @IntoSet fun networkModule() : DebugDrawerSection = NetworkModule()
    @Provides @IntoSet fun settingsModule() : DebugDrawerSection = SettingsModule()
}

/**
 * Orders a [Set] of [DebugModule] in some sensible manner. We're just doing it by [Class.getSimpleName]
 * for now because it's a decent enough order and easy to compare. This returns an array so we
 * can pass it to the drawer builder as a `vararg`
 */
fun Set<DebugDrawerSection>.debugModulesOrderedBySimpleClassName() : Array<DebugDrawerSection> {
    return this.toList().sortedWith(compareBy({ it.javaClass.simpleName })).toTypedArray()
}
