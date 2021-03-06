package drivechain.bridge.stetho

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import drivechain.bridge.okhttp.NetworkOnly
import drivechain.lifecycle.application.ApplicationLifecycleSubscriber
import okhttp3.Interceptor

@Module class StethoBridgeModule {
    @Provides @IntoSet fun stethoBridge(): ApplicationLifecycleSubscriber = StethoInitializer()
    @Provides @NetworkOnly @IntoSet fun okhttpInterceptor(): Interceptor = StethoInterceptor()
}