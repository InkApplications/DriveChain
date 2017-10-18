package drivechain.bridge.okhttp

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Singleton
import java.io.File

@Module class OkHttpBridgeModule {
    @Provides @Singleton fun okHttp(
            interceptors: Set<@JvmSuppressWildcards Interceptor>,
            @NetworkOnly networkInterceptors: Set<@JvmSuppressWildcards Interceptor>,
            context: Context
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        interceptors.forEach { builder.addInterceptor(it) }
        networkInterceptors.forEach { builder.addNetworkInterceptor(it) }
        val cacheSize = 50 * 1024 * 1024L // 50MB
        builder.cache(Cache(File(context.cacheDir, "OkHttpCache"), cacheSize))

        return builder.build()
    }

    @Provides @IntoSet fun emptyInterceptor() = Interceptor { chain -> chain.proceed(chain.request()) }
    @Provides @NetworkOnly @IntoSet fun emptyNetworkInterceptor() = Interceptor { chain -> chain.proceed(chain.request()) }
}