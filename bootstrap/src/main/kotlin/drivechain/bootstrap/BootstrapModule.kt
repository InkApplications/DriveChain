package drivechain.bootstrap

import dagger.Module
import drivechain.androidservices.AndroidApplicationModule
import drivechain.androidservices.AndroidSystemServiceModule
import drivechain.bridge.threeten.ThreeTenBridgeModule
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
    AndroidApplicationModule::class,
    AndroidSystemServiceModule::class,
    ThreeTenBridgeModule::class
]) class BootstrapModule
