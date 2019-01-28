package drivechain.appconfig

import android.content.Context
import android.content.pm.ApplicationInfo
import android.os.Build
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module class AppInfoModule {
    @Provides @Reusable fun getAppInfo(context: Context): AppInfo {
        val info = context.packageManager.getPackageInfo(context.packageName, 0)
        return AppInfo(
            appId = info.packageName,
            versionName = info.versionName,
            debug = context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0,
            versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) info.longVersionCode else info.versionCode.toLong()
        )
    }
}
