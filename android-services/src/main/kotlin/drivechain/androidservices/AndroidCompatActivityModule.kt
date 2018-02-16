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
@Module class AndroidCompatActivityModule {
    @Provides @ActivityScope fun compatActivity(activity: AppCompatActivity) : AppCompatActivity = activity
    @Provides @ActivityScope fun supportActionBar(activity: AppCompatActivity) = activity.supportActionBar
    @Provides @ActivityScope fun supportFragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    @Provides @ActivityScope fun layoutInflater(activity: AppCompatActivity) = activity.layoutInflater
    @Provides @ActivityScope fun menuInflater(activity: AppCompatActivity) = activity.menuInflater
    @Provides @ActivityScope fun windowManager(activity: AppCompatActivity) = activity.windowManager
    @Provides @ActivityScope fun lifecycle(activity: AppCompatActivity) = activity.lifecycle
    @Provides @ActivityScope fun supportLoaderManager(activity: AppCompatActivity) = activity.supportLoaderManager
}