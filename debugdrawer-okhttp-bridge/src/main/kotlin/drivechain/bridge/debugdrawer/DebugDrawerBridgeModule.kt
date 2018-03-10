package drivechain.bridge.debugdrawer

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import io.palaima.debugdrawer.network.quality.NetworkQualityModule
import io.palaima.debugdrawer.okhttp3.OkHttp3Module
import okhttp3.OkHttpClient

@Module class DebugDrawerOkHttpBridgeModule {
    @Provides @IntoSet fun okhttpModule(okHttpClient: OkHttpClient) : DebugDrawerSection = OkHttp3Module(okHttpClient)
    @Provides @IntoSet fun networkQualityModule(context: Context) : DebugDrawerSection = NetworkQualityModule(context)
}
