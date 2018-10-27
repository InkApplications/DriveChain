package com.acme.example.dependencyinjection

import com.acme.example.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.Reusable
import drivechain.appconfig.AppConfig

@Module class AppConfigModule {
    @Provides @Reusable fun appConfig() = AppConfig(
        debug = BuildConfig.DEBUG,
        buildFlavor = BuildConfig.FLAVOR,
        appId = BuildConfig.APPLICATION_ID,
        versionName = BuildConfig.VERSION_NAME,
        buildType = BuildConfig.BUILD_TYPE,
        versionCode = BuildConfig.VERSION_CODE
    )
}
