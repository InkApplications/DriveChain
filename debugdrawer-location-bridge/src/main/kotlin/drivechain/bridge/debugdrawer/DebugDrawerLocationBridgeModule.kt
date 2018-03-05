package drivechain.bridge.debugdrawer

import com.google.android.gms.location.LocationRequest
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import io.palaima.debugdrawer.base.DebugModule
import io.palaima.debugdrawer.location.LocationModule

@Module class DebugDrawerLocationBridgeModule {
    @Provides @IntoSet fun locationModule(locationRequest: LocationRequest) : DebugModule = LocationModule(locationRequest)
}
