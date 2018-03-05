import dagger.Module
import dagger.Provides
import io.palaima.debugdrawer.base.DebugModule
import javax.inject.Singleton

@Module class DebugDrawerBridgeModule {
    @Provides @Singleton fun debugModuleSet() : Set<DebugModule> = setOf() // empty set for release
}