package drivechain.androidservices

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import drivechain.appconfig.AppInfo
import javax.inject.Singleton

/**
 * Services hiding inside the Android Application class, made Injectable.
 *
 * Use this to inject android's system services directly into your app instead of injecting a whole
 * application class directly.
 */
@Module class AndroidApplicationModule(private val application: Application) {
    @Provides @Singleton fun genericSharedPreferences(config: AppInfo): SharedPreferences {
        return application.getSharedPreferences(config.appId, Context.MODE_PRIVATE)
    }
    @Provides @Singleton fun application() = application
    @Provides @Singleton fun context() = application.applicationContext
    @Provides @Singleton fun applicationInfo() = application.applicationInfo
    @Provides @Singleton fun assets() = application.assets
    @Provides @Singleton fun classLoader() = application.classLoader
    @Provides @Singleton fun contentResolver() = application.contentResolver
    @Provides @Singleton fun mainLooper() = application.mainLooper
    @Provides @Singleton fun packageManager() = application.packageManager
    @Provides @Singleton fun resources() = application.resources
    @Provides @Singleton fun theme() = application.theme
}
