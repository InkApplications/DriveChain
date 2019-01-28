package drivechain.bootstrap

import dagger.Module
import drivechain.androidservices.AndroidApplicationModule
import drivechain.androidservices.AndroidSystemServiceModule
import drivechain.appconfig.AppInfoModule
import drivechain.lifecycle.LifecycleModule
import drivechain.logger.AutoLoggers

/**
 * A Single module for base projects to include for typical defaults.
 *
 * Using this module is not required, and is simply a shortcut to reduce
 * boilerplate in typical setups.
 */
@Module(includes = [
    AutoLoggers::class,
    LifecycleModule::class,
    AppInfoModule::class,
    AndroidApplicationModule::class,
    AndroidSystemServiceModule::class
]) class BootstrapModule
