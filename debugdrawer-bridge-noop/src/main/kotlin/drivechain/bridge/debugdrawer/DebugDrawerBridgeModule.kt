import dagger.Module
import dagger.Provides
import io.palaima.debugdrawer.base.DebugModule
import javax.inject.Singleton

typealias DebugDrawerSection = DebugModule

/**
 * No-op version of this module that just binds an empty [Set] of []
 */
@Module class DebugDrawerBridgeModule {
    @Provides @Singleton fun debugModuleSet() : Set<DebugDrawerSection> = setOf() // empty set for release
}

/**
 * Orders a [Set] of [DebugModule] in some sensible manner. We're just doing it by [Class.getSimpleName]
 * for now because it's a decent enough order and easy to compare. This returns an array so we
 * can pass it to the drawer builder as a `vararg`
 */
fun Set<DebugDrawerSection>.debugModulesOrderedBySimpleClassName() : Array<DebugDrawerSection> {
    return this.toList().sortedWith(compareBy({ it.javaClass.simpleName })).toTypedArray()
}
