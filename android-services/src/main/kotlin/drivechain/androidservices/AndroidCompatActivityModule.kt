package drivechain.androidservices

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 * Services hiding inside the Android Activity class, made Injectable.
 *
 * Use this to inject android's system services directly into your app instead of injecting a whole
 * Activity class directly.
 *
 * These services will only be available to an activity scoped component, as they require the
 * activity class to be created.
 */
@Module class AndroidCompatActivityModule(private val activity: AppCompatActivity) {
    @Provides @ActivityScope fun compatActivity() = activity
    @Provides @ActivityScope fun activity(): Activity = activity
    @Provides @ActivityScope fun supportActionBar() = activity.supportActionBar
    @Provides @ActivityScope fun supportFragmentManager() = activity.supportFragmentManager
    @Provides @ActivityScope fun layoutInflater() = activity.layoutInflater
    @Provides @ActivityScope fun menuInflater() = activity.menuInflater
    @Provides @ActivityScope fun windowManager() = activity.windowManager
    @Provides @ActivityScope fun lifecycle() = activity.lifecycle
    @Provides @ActivityScope fun supportLoaderManager() = activity.supportLoaderManager
}