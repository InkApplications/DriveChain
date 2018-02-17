package drivechain.androidservices

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Services hiding inside the Android Application class, made Injectable.
 *
 * Use this to inject android's system services directly into your app instead of injecting a whole
 * application class directly.
 */
@Module class AndroidApplicationModule {
    @Provides @Singleton fun genericSharedPreferences(application: Application): SharedPreferences = application.getSharedPreferences("ApplicationPreferences", Context.MODE_PRIVATE)
    @Provides @Singleton fun context(application: Application) = application.applicationContext
    @Provides @Singleton fun applicationInfo(application: Application) = application.applicationInfo
    @Provides @Singleton fun assets(application: Application) = application.assets
    @Provides @Singleton fun classLoader(application: Application) = application.classLoader
    @Provides @Singleton fun contentResolver(application: Application) = application.contentResolver
    @Provides @Singleton fun mainLooper(application: Application) = application.mainLooper
    @Provides @Singleton fun packageManager(application: Application) = application.packageManager
    @Provides @Singleton fun resources(application: Application) = application.resources
    @Provides @Singleton fun theme(application: Application) = application.theme
}