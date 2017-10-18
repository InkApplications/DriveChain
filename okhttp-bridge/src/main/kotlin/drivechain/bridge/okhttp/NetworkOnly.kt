package drivechain.bridge.okhttp

import javax.inject.Qualifier

/**
 * Indicates that an OkHTTP Interceptor should be bound as a Network Interceptor.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class NetworkOnly